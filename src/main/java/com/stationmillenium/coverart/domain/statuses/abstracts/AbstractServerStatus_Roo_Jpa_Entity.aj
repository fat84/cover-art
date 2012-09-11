// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain.statuses.abstracts;

import com.stationmillenium.coverart.domain.statuses.abstracts.AbstractServerStatus;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

privileged aspect AbstractServerStatus_Roo_Jpa_Entity {
    
    declare @type: AbstractServerStatus: @Entity;
    
    declare @type: AbstractServerStatus: @Inheritance(strategy = InheritanceType.SINGLE_TABLE);
    
    declare @type: AbstractServerStatus: @DiscriminatorColumn;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long AbstractServerStatus.id;
    
    @Version
    @Column(name = "version")
    private Integer AbstractServerStatus.version;
    
    public Long AbstractServerStatus.getId() {
        return this.id;
    }
    
    public void AbstractServerStatus.setId(Long id) {
        this.id = id;
    }
    
    public Integer AbstractServerStatus.getVersion() {
        return this.version;
    }
    
    public void AbstractServerStatus.setVersion(Integer version) {
        this.version = version;
    }
    
}
