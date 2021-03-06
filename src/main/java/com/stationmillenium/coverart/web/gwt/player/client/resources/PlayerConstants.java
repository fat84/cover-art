package com.stationmillenium.coverart.web.gwt.player.client.resources;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.LocalizableResource.GenerateKeys;

/**
 * Constants for the player GWT module
 * @author vincent
 *
 */
@GenerateKeys
@Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
public interface PlayerConstants extends Constants {

	@DefaultStringValue("Player Millenium")
	String getWindowTitle();
	
	@DefaultStringValue("Station Millenium")
	String songUnaivalaible();
	
	@DefaultStringValue("http://www.station-millenium.com/cetait-quoi-ce-titre/")
	String lastSongsURL();
	
	@DefaultStringValue("http://www.station-millenium.com/radio/la-grille-des-programmes/")
	String programScheduleURL();
	
	@DefaultStringValue("http://www.station-millenium.com/contact/")
	String contactURL();
	
	@DefaultStringValue("https://play.google.com/store/apps/details?id=com.stationmillenium.android")
	String googlePlayURL();
	
	@DefaultStringValue("https://www.facebook.com/station.millenium")
	String facebookURL();
	
	@DefaultStringValue("https://twitter.com/Millenium22")
	String twitterURL();
	
}
