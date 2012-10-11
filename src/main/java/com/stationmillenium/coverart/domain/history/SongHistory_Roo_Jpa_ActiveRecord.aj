// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain.history;

import com.stationmillenium.coverart.domain.history.SongHistory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SongHistory_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SongHistory.entityManager;
    
    public static final EntityManager SongHistory.entityManager() {
        EntityManager em = new SongHistory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SongHistory.countSongHistorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SongHistory o", Long.class).getSingleResult();
    }
    
    public static List<SongHistory> SongHistory.findAllSongHistorys() {
        return entityManager().createQuery("SELECT o FROM SongHistory o", SongHistory.class).getResultList();
    }
    
    public static SongHistory SongHistory.findSongHistory(Long id) {
        if (id == null) return null;
        return entityManager().find(SongHistory.class, id);
    }
    
    public static List<SongHistory> SongHistory.findSongHistoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SongHistory o", SongHistory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SongHistory.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SongHistory.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SongHistory attached = SongHistory.findSongHistory(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SongHistory.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SongHistory.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SongHistory SongHistory.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SongHistory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}