// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.dto.hybrid;

import com.stationmillenium.coverart.dto.services.history.SongHistoryItemDTO;
import com.stationmillenium.coverart.dto.services.images.SongImageDTO;

privileged aspect SongHistoryItemImageDTO_Roo_JavaBean {
    
	public SongHistoryItemDTO SongHistoryItemImageDTO.getSongHistoryItemDTO() {
		return songHistoryItemDTO;
	}

	public void SongHistoryItemImageDTO.setSongHistoryItemDTO(SongHistoryItemDTO songHistoryItemDTO) {
		this.songHistoryItemDTO = songHistoryItemDTO;
	}

	public SongImageDTO SongHistoryItemImageDTO.getSongImageDTO() {
		return songImageDTO;
	}

	public void SongHistoryItemImageDTO.setSongImageDTO(SongImageDTO songImageDTO) {
		this.songImageDTO = songImageDTO;
	} 
    
}