package comp3350.go2fit.business;

import junit.framework.TestCase;
import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.Models.TrackProgressModel;

public class ProgressManagerTest extends TestCase {
    private ProgressManager progressManager;
    private TrackProgressModel trackProgress;

    @Test
    public void testForNull() {
        System.out.println("\nStarting testProcessManager: null database");

        progressManager = new ProgressManager();
        assertNotNull(progressManager);

        System.out.println("Finished testProcessManager: null database");
    }

    @Test
    public void testGetProgressForNull() {
        System.out.println("\nStarting testProcessManager: get progress");
        progressManager = new ProgressManager();
        trackProgress = progressManager.getProgress(0);
        assertNotNull(trackProgress);

        System.out.println("Finished testProcessManager: Null progress check");
    }

    @Test
    public void testAddDatabase()
    {

        System.out.println("\nStarting testProcessManager: check Add ");
        progressManager = new ProgressManager();
        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(1);
        data.setId(1);

        boolean result = progressManager.addProgress(data);
        assertTrue(result);

        System.out.println("Finished testProcessManager: check add");
    }
}

