package comp3350.go2fit.objects;

import junit.framework.TestCase;

import org.junit.Test;
import comp3350.go2fit.Models.TrackProgressModel;

public class TrackProgressModelTest extends TestCase {

    @Test
    public void testTrackProgressModel1()
    {
        TrackProgressModel trackProgressModel;

        System.out.println("\nStarting testTrackProgressModel");

        trackProgressModel = new TrackProgressModel();
        // test for valid data
        System.out.println("Testing valid data in the TrackProgressModel class.");
        trackProgressModel.setNumSteps(1200);
        assertEquals(1200, trackProgressModel.getNumSteps());


        trackProgressModel.setPercentageComplete(20);
        assertEquals(20, trackProgressModel.getPercentageComplete());

        trackProgressModel.setId(1);
        trackProgressModel.setDistance(12.3);

        assertEquals(1, trackProgressModel.getId());
        assertEquals(12.3, trackProgressModel.getDistance());

        // test for null object
        assertNotNull(trackProgressModel);
        System.out.println("TrackProgressModel object is not null");

        // test invalid data
        System.out.println("Testing invalid data in the TrackProgressModel class.");
        assertNotSame(1, trackProgressModel.getCalories());
        assertFalse(trackProgressModel.getId() < 0);

        System.out.println("Finished testTrackProgressModel");
    }
}
