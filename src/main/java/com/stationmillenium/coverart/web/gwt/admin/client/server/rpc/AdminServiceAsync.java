/**
 * 
 */
package com.stationmillenium.coverart.web.gwt.admin.client.server.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.stationmillenium.coverart.web.gwt.admin.shared.rpc.ServicesStatuses;
import com.stationmillenium.coverart.web.gwt.admin.shared.rpc.SongGWT;


/**
 * Service async for the admin GWT module
 * @author vincent
 *
 */
public interface AdminServiceAsync {

	void getServicesStatuses(AsyncCallback<ServicesStatuses> callback);
	void setFMAlertStatus(boolean enabled, AsyncCallback<Void> callback);
	void setPollingServiceStatus(boolean enabled, AsyncCallback<Void> callback);
	void getCurrentTitle(AsyncCallback<String> callback);
	void isIndexingActive(AsyncCallback<Boolean> callback);
	void launchIndexing(AsyncCallback<Void> callback);
	void launchMissingImagesRecovery(AsyncCallback<Void> callback);
	void isRecoveryFinished(AsyncCallback<Boolean> callback);
	void getRecoveredSongs(AsyncCallback<List<SongGWT>> callback);
	void searchSongsWithoutCustomImage(String keywords, int limit, AsyncCallback<List<SongGWT>> callback);
	void searchSongsWithoutCustomImage(String keywords, AsyncCallback<List<SongGWT>> callback);
	void searchSongsWithCustomImage(String keywords, AsyncCallback<List<SongGWT>> callback);
	void searchSongsWithCustomImage(String keywords, int limit, AsyncCallback<List<SongGWT>> callback);
	void getAllCustomImageSong(AsyncCallback<List<SongGWT>> callback);
	void setSongAsSongWithCustomImage(SongGWT songToSet,	AsyncCallback<Void> callback);
	void removeCustomImageOnSong(SongGWT songToRemoveCustomImage, AsyncCallback<Void> callback);
	
}
