package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.tests.persistence.TrackProgressPersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class ProgressManagerIT {
    private File tempDB;
    private ProgressManager progressManager;
    private TrackProgressModel trackProgress;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        this.progressManager = new ProgressManager();
    }

    @Test
    public void testForNull() {
        System.out.println("\nStarting testProgressManager: null database");
        assertNotNull(progressManager);
        System.out.println("Finished testProgressManager: null database");

//        System.out.println("\nStarting testProgressManager: get progress");
//        trackProgress = progressManager.getProgress(0);
//        assertNotNull(trackProgress);
//        System.out.println("Finished testProgressManager: Null progress check");
    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }

    @Before
    public void setUp1() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        this.progressManager = new ProgressManager();
    }

    @Test
    public void testAddDatabase()
    {
        System.out.println("\nStarting testProgressManager: check Add ");
        progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(1);
        data.setId(1);

        boolean result = progressManager.addProgress(data);
        assertTrue(result);

        System.out.println("Finished testProgressManager: check add");
    }

    @After
    public void tearDown1()
    {
        //reset DB
        this.tempDB.delete();
    }

    @Before
    public void setUp2() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        this.progressManager = new ProgressManager();
    }


    @Test
    public void testFail()
    {
        System.out.println("Starting testProgressManager: check fail challenge");
        //progressManager.failedChallenge();
        System.out.println("Starting testProgressManager: check fail challenge passed");
    }


    @After
    public void tearDown2()
    {
        //reset DB
        this.tempDB.delete();
    }


    @Before
    public void setUp3() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        this.progressManager = new ProgressManager();
    }


    @Test
    public void testRemove() {
        assertTrue(progressManager.remove(0));
        System.out.println("Finishing testProgressManager: check remove");
    }


    @After
    public void tearDown3()
    {
        //reset DB
        this.tempDB.delete();
    }


    @Before
    public void setUp4() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        this.progressManager = new ProgressManager();
    }


    @Test
    public void testUpdateDatabase() {
        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(0);
        data.setId(0);
        progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        boolean result = progressManager.updateDatabase(data);
        assertTrue(result);
    }


    @After
    public void tearDown4()
    {
        //reset DB
        this.tempDB.delete();
    }
}
