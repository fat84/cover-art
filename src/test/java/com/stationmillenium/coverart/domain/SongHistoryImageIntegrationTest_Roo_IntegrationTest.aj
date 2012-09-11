// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stationmillenium.coverart.domain;

import com.stationmillenium.coverart.domain.SongHistoryImageDataOnDemand;
import com.stationmillenium.coverart.domain.SongHistoryImageIntegrationTest;
import com.stationmillenium.coverart.domain.history.SongHistoryImage;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SongHistoryImageIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SongHistoryImageIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SongHistoryImageIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SongHistoryImageIntegrationTest: @Transactional;
    
    @Autowired
    private SongHistoryImageDataOnDemand SongHistoryImageIntegrationTest.dod;
    
    @Test
    public void SongHistoryImageIntegrationTest.testCountSongHistoryImages() {
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", dod.getRandomSongHistoryImage());
        long count = SongHistoryImage.countSongHistoryImages();
        Assert.assertTrue("Counter for 'SongHistoryImage' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testFindSongHistoryImage() {
        SongHistoryImage obj = dod.getRandomSongHistoryImage();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to provide an identifier", id);
        obj = SongHistoryImage.findSongHistoryImage(id);
        Assert.assertNotNull("Find method for 'SongHistoryImage' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'SongHistoryImage' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testFindAllSongHistoryImages() {
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", dod.getRandomSongHistoryImage());
        long count = SongHistoryImage.countSongHistoryImages();
        Assert.assertTrue("Too expensive to perform a find all test for 'SongHistoryImage', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<SongHistoryImage> result = SongHistoryImage.findAllSongHistoryImages();
        Assert.assertNotNull("Find all method for 'SongHistoryImage' illegally returned null", result);
        Assert.assertTrue("Find all method for 'SongHistoryImage' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testFindSongHistoryImageEntries() {
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", dod.getRandomSongHistoryImage());
        long count = SongHistoryImage.countSongHistoryImages();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<SongHistoryImage> result = SongHistoryImage.findSongHistoryImageEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'SongHistoryImage' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'SongHistoryImage' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testFlush() {
        SongHistoryImage obj = dod.getRandomSongHistoryImage();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to provide an identifier", id);
        obj = SongHistoryImage.findSongHistoryImage(id);
        Assert.assertNotNull("Find method for 'SongHistoryImage' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifySongHistoryImage(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'SongHistoryImage' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testMergeUpdate() {
        SongHistoryImage obj = dod.getRandomSongHistoryImage();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to provide an identifier", id);
        obj = SongHistoryImage.findSongHistoryImage(id);
        boolean modified =  dod.modifySongHistoryImage(obj);
        Integer currentVersion = obj.getVersion();
        SongHistoryImage merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'SongHistoryImage' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", dod.getRandomSongHistoryImage());
        SongHistoryImage obj = dod.getNewTransientSongHistoryImage(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'SongHistoryImage' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'SongHistoryImage' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SongHistoryImageIntegrationTest.testRemove() {
        SongHistoryImage obj = dod.getRandomSongHistoryImage();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SongHistoryImage' failed to provide an identifier", id);
        obj = SongHistoryImage.findSongHistoryImage(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'SongHistoryImage' with identifier '" + id + "'", SongHistoryImage.findSongHistoryImage(id));
    }
    
}
