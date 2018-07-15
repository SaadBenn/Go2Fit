package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.hsqldb.rights.User;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.tests.persistence.TrackProgressPersistenceStub;

public class ProgressManagerTest extends TestCase {
    private ProgressManager progressManager;
    private ProgressManager progressManager1;
    private TrackProgressModel trackProgress;
    private TrackProgressPersistence trackProgressPersistence;

    @Before
    public void setUp() {
        trackProgressPersistence = mock(TrackProgressPersistence.class);
        progressManager1 = new ProgressManager(trackProgressPersistence);
    }

    @Test
    public void testForNull() {
        System.out.println("\nStarting testProgressManager: null database");

        progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        assertNotNull(progressManager);

        System.out.println("Finished testProgressManager: null database");
    }

    @Test
    public void testGetProgressForNull() {
        System.out.println("\nStarting testProgressManager: get progress");
        progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        trackProgress = progressManager.getProgress(0);
        assertNotNull(trackProgress);

        System.out.println("Finished testProgressManager: Null progress check");
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

    @Test
    public void testForRemove() {
        System.out.println("Starting testProgressManager: check remove");

        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(0);
        data.setId(0);
        progressManager = new ProgressManager(new TrackProgressPersistenceStub());
        progressManager.addProgress(data);

        assertTrue(progressManager.remove(0));

        System.out.println("Finishing testProgressManager: check remove");
    }
}

