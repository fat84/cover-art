// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain.statuses;

import com.stationmillenium.coverart.domain.statuses.ServerStatus;

privileged aspect ServerStatus_Roo_JavaBean {
    
    public boolean ServerStatus.isServerUp() {
        return this.serverUp;
    }
    
    public void ServerStatus.setServerUp(boolean serverUp) {
        this.serverUp = serverUp;
    }
    
}