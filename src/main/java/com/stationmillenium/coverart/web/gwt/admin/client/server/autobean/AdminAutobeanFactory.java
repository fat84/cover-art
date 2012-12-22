/**
 * 
 */
package com.stationmillenium.coverart.web.gwt.admin.client.server.autobean;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.stationmillenium.coverart.web.gwt.admin.shared.autobean.PlaylistExtract;

/**
 * Autobean factory for GWT admin module
 * @author vincent
 *
 */
public interface AdminAutobeanFactory extends AutoBeanFactory {

	AutoBean<PlaylistExtract> getPlaylistExtract();
	
}
