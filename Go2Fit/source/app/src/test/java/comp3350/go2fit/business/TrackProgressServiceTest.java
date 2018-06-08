package comp3350.go2fit.business;

import junit.framework.TestCase;

import org.junit.Test;
import comp3350.go2fit.BuisnessLayer.TrackProgressService;


public class TrackProgressServiceTest extends TestCase {

    private TrackProgressService trackProgressService = new TrackProgressService();

    @Test
    public void testForNull() {
        System.out.println("\nStarting testUserManager: null database");
        assertNotNull(trackProgressService);
        System.out.println("Finished testUserManager: null database");
    }

    @Test
    public void verifyCalc() {

        int actual = trackProgressService.determineProgress(100, 200);
        int expected = 50;

        assertEquals(expected, actual);

        assertTrue(trackProgressService.determineHours(1) instanceof String);
        assertTrue(trackProgressService.determineMinutes(1) instanceof String);
        assertTrue(trackProgressService.determineSeconds(1) instanceof String);
    }

    @Test
    public void testDistanceAndCalories() {

        double actual = trackProgressService.calculateDistance(100);
        double expected = 70.104;
        assertEquals(expected, actual);

        actual = trackProgressService.calculateCaloriesBurned(120.0);
        expected = 5.927895907639157;

        assertEquals(expected, actual);
    }







}
