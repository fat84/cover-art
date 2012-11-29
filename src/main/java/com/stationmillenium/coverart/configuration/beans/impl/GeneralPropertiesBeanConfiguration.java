/**
 * 
 */
package com.stationmillenium.coverart.configuration.beans.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stationmillenium.coverart.beans.utils.GeneralPropertiesBean;
import com.stationmillenium.coverart.configuration.beans.AbstractPropertiesBeanConfiguration;
import com.stationmillenium.coverart.exceptions.PropertyBeanException;

/**
 * Shoutcast server properties bean configuration
 * @author vincent
 *
 */
@Configuration
public class GeneralPropertiesBeanConfiguration extends AbstractPropertiesBeanConfiguration<GeneralPropertiesBean> {

	//property list
	private @Value("${generalConfiguration.coverImagesPath}") String coverImagesPath;
	private @Value("${generalConfiguration.coverImagesExtension}") String coverImagesExtension;
	private @Value("${generalConfiguration.fallbackPath}") String fallbackPath;
	private @Value("${generalConfiguration.playlistUpdateTimeout}") String playlistUpdateTimeout;
	private @Value("${generalConfiguration.alertTimeout}") String alertTimeout;
	private @Value("${generalConfiguration.historyDisplayMinMinutes}") String historyDisplayMinMinutes;
	private @Value("${generalConfiguration.dateSearchDelta}") String dateSearchDelta;
	private @Value("${generalConfiguration.fmAlertTimeout}") String fmAlertTimeout;
	
	//instance vars
	private int playlistUpdateTimeoutInt;
	private int alertTimeoutInt;
	private int historyDisplayMinMinutesInt;
	private int dateSearchDeltaInt;
	private int fmAlertTimeoutInt;
	
	@Override
	protected GeneralPropertiesBean buildBean() {
		GeneralPropertiesBean propertiesBean = new GeneralPropertiesBean();
		propertiesBean.setCoverImagesPath(coverImagesPath);
		propertiesBean.setCoverImagesExtension(coverImagesExtension);
		propertiesBean.setFallbackPath(fallbackPath);
		propertiesBean.setPlaylistUpdateTimeout(playlistUpdateTimeoutInt);
		propertiesBean.setAlertTimeout(alertTimeoutInt);
		propertiesBean.setHistoryDisplayMinMinutes(historyDisplayMinMinutesInt);
		propertiesBean.setDateSearchDelta(dateSearchDeltaInt);
		propertiesBean.setFmAlertTimeout(fmAlertTimeoutInt);
		return propertiesBean;
	}
	
	@Override
	protected void propertyCustomChecker() throws PropertyBeanException {
		try { //convert playlistUpdateTimeout into number
			playlistUpdateTimeoutInt = Integer.parseInt(playlistUpdateTimeout);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("playlistUpdateTimeout", e);
		}
		
		try { //convert alertTimeout into number
			alertTimeoutInt = Integer.parseInt(alertTimeout);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("alertTimeout", e);
		}
		
		try { //convert historyDisplayMinMinutes into number
			historyDisplayMinMinutesInt = Integer.parseInt(historyDisplayMinMinutes);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("historyDisplayMinMinutes", e);
		}
		
		try { //convert dateSearchDelta into number
			dateSearchDeltaInt = Integer.parseInt(dateSearchDelta);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("dateSearchDelta", e);
		}
		
		try { //convert fmAlertTimeout into number
			fmAlertTimeoutInt = Integer.parseInt(fmAlertTimeout);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("fmAlertTimeout", e);
		}
	}

	/**
	 * Provide the produced bean
	 * @return the <code>GeneralPropertiesBean</code>
	 */
	@Bean
	@Qualifier("generalPropertiesBean")
	public GeneralPropertiesBean getGeneralPropertiesBean() {
		return assembleBean();
	}
	
}
