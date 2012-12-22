// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain.statuses;

import com.stationmillenium.coverart.domain.statuses.ServerStatus;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ServerStatus_Roo_Jpa_ActiveRecord {
    
    public static long ServerStatus.countServerStatuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ServerStatus o", Long.class).getSingleResult();
    }
    
    public static List<ServerStatus> ServerStatus.findAllServerStatuses() {
        return entityManager().createQuery("SELECT o FROM ServerStatus o", ServerStatus.class).getResultList();
    }
    
    public static ServerStatus ServerStatus.findServerStatus(Long id) {
        if (id == null) return null;
        return entityManager().find(ServerStatus.class, id);
    }
    
    public static List<ServerStatus> ServerStatus.findServerStatusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ServerStatus o", ServerStatus.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public ServerStatus ServerStatus.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ServerStatus merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
