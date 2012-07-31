/**
 * 
 */
package com.stationmillenium.coverart.services.covergraber.impl;

import java.awt.image.BufferedImage;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stationmillenium.coverart.beans.covergraber.LastFMCoverServicePropertiesBean;
import com.stationmillenium.coverart.schema.lastfmtracksearch.Lfm;
import com.stationmillenium.coverart.schema.lastfmtracksearch.Lfm.Track;
import com.stationmillenium.coverart.schema.lastfmtracksearch.Lfm.Track.Album;
import com.stationmillenium.coverart.schema.lastfmtracksearch.Lfm.Track.Album.Image;
import com.stationmillenium.coverart.services.covergraber.CoverGraberServiceInterface;

/**
 * Cover graber for Last FM service
 * @author vincent
 *
 */
@Service
public class LastFmCoverGraberService implements CoverGraberServiceInterface {

	//logger
	private static final Logger LOGGER = LoggerFactory.getLogger(LastFmCoverGraberService.class);
		
	/**
	 * Available image size list
	 * @author vincent
	 *
	 */
	private enum ImageSize  {
		EXTRALARGE,
		LARGE,
		MEDIUM,
		SMALL;
	}
	
	//conf
	@Autowired
	private LastFMCoverServicePropertiesBean lastFMCoverServicePropertiesBean;
	
	//xml marshallers
	@Autowired
	@Qualifier("oxmLastFMTrackSearch")
	private Jaxb2Marshaller oxmLastFMTrackSearch;
		
	@Override
	public BufferedImage grabCover(String artist, String title) {
		String xmlData = gatherXMLData(artist, title); //gather XML
		if (xmlData != null) {
			Lfm lfm = unmarshallNormalData(xmlData);  //unmarshall
			if (lfm != null) { //process data
				Track track = lfm.getTrack();
				if (track != null) {
					Album album = track.getAlbum();
					if (album != null) {
						List<Image> imageList = album.getImage();
						if (imageList != null) {
							if (imageList.size() > 0) {
								
								//all data are defined
								String imageURL = extractImageURL(imageList); //try to gather url
								LOGGER.debug("Image URL found : " + imageURL);								
								return gatherImage(imageURL);
								
							} else
								LOGGER.warn("XML album image list empty");
						} else
							LOGGER.warn("XML album image list null");					
					} else
						LOGGER.warn("XML album data null");
				} else
					LOGGER.warn("XML track data null");				
			} else  
				LOGGER.error("Last FM data as object null");	//some error might have occured		
		} else
			LOGGER.debug("Last FM xml data nulll");
		
		return null;
	}

	/**
	 * Extract image URL
	 * @param imageList the image list from XML
	 * @return the found image URL or null if not found
	 */
	private String extractImageURL(List<Image> imageList) {
		String imageURL = null;
		for (Image image : imageList) { //for each image
			if ((image != null) && (lastFMCoverServicePropertiesBean.getImageSize().equalsIgnoreCase(image.getSize()))) {
				imageURL = image.getValue();
			}
		}
		
		if (imageURL == null) { //image not found, try to find the biggest one 
			for (ImageSize imageSize :  ImageSize.values()) {
				for (Image image : imageList) {
					if ((image != null) && (imageSize.toString().equalsIgnoreCase(image.getSize()))) {
						imageURL = image.getValue();
						LOGGER.warn("Unable to find configured image size - used : " + imageSize);
						break;
					}
				}
				
				if (imageURL != null)
					break;
			}
		}
		return imageURL;
	}

	/**
	 * Gather XML data for a song search
	 * @param artist the artist to search
	 * @param title the title to search
	 * @return the XML data as {@code String} or null if error
	 */
	private String gatherXMLData(String artist, String title)  {
		try {
			RestTemplate template = new RestTemplate();
			String xmlData = template.getForObject(lastFMCoverServicePropertiesBean.getUrl(), String.class, lastFMCoverServicePropertiesBean.getApiKey(), artist, title);
			xmlData = xmlData.replace(lastFMCoverServicePropertiesBean.getTextToRemoveInXML(), "");
			
			LOGGER.debug("Gathered XML data : " + xmlData);
			return xmlData;
		} catch (Exception e) { //if error occurs
			LOGGER.warn("Error during query of Last FM", e);
			return null;
		}
	}
	
	/**
	 * Unmarshall the xml data as normal data 
	 * @param xmlData the xml data as string
	 * @return the {@link Lfm} or null if error occured
	 */
	private Lfm unmarshallNormalData(String xmlData) {
		try {
			oxmLastFMTrackSearch.setSchema(new ClassPathResource("xsd/LastFMTrackSearch.xsd"));
			Lfm returnXMl = (Lfm) oxmLastFMTrackSearch.unmarshal(new StreamSource(new StringReader(xmlData)));
			return returnXMl;
		} catch (XmlMappingException e) {
			LOGGER.warn("Error while unmarshalling normal data", e);
			return null;
		}
	}
	
	/**
	 * Gather image container
	 * @param urlText the URL of the image
	 * @return the image 
	 */
	private BufferedImage gatherImage(String urlText)  {
		try {
			URL url = new URL(urlText);
			BufferedImage image = ImageIO.read(url);
			LOGGER.debug("Gathered image : " +  image);
			return image;
		} catch (Exception e) { //if error occurs
			LOGGER.warn("Error during gathering image", e);
			return null;
		}
	}

}
