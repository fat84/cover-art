// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain.alert;

import com.stationmillenium.coverart.domain.alert.AlertEmail;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect AlertEmail_Roo_Jpa_Entity {
    
    declare @type: AlertEmail: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long AlertEmail.id;
    
    @Version
    @Column(name = "version")
    private Integer AlertEmail.version;
    
    public Long AlertEmail.getId() {
        return this.id;
    }
    
    public void AlertEmail.setId(Long id) {
        this.id = id;
    }
    
    public Integer AlertEmail.getVersion() {
        return this.version;
    }
    
    public void AlertEmail.setVersion(Integer version) {
        this.version = version;
    }
    
}
