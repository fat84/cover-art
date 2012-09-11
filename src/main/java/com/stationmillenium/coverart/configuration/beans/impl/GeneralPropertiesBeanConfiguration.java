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
	
	//instance vars
	private int playlistUpdateTimeoutInt;
	
	@Override
	protected GeneralPropertiesBean buildBean() {
		GeneralPropertiesBean propertiesBean = new GeneralPropertiesBean();
		propertiesBean.setCoverImagesPath(coverImagesPath);
		propertiesBean.setCoverImagesExtension(coverImagesExtension);
		propertiesBean.setFallbackPath(fallbackPath);
		propertiesBean.setPlaylistUpdateTimeout(playlistUpdateTimeoutInt);
		return propertiesBean;
	}
	
	@Override
	protected void propertyCustomChecker() throws PropertyBeanException {
		try {
			playlistUpdateTimeoutInt = Integer.parseInt(playlistUpdateTimeout);
		} catch(NumberFormatException e) {
			throw new PropertyBeanException("playlistUpdateTimeout", e);
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
