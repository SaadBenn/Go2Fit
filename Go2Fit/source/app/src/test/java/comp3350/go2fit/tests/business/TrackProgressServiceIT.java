package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.TrackProgressService;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TrackProgressServiceIT {


    private File tempDB;
    private TrackProgressService trackProgressService;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.trackProgressService = new TrackProgressService();
    }


    @Test
    public void testDistanceAndCalories() {

        System.out.println("\nStarting testUserManager: null database check");
        assertNotNull(trackProgressService);
        System.out.println("Finished testUserManager: null database check passed");

        System.out.println("Starting test distanceAndCalories");
        double actual = trackProgressService.calculateDistance(100);
        double expected = 70.104;
        assertEquals(expected, actual);
        actual = trackProgressService.calculateCaloriesBurned(120.0);
        expected = 5.927895907639157;
        assertEquals(expected, actual);
        System.out.println("Finished test distanceAndCalories");

        System.out.println("Starting test verifyCalc");
        actual = trackProgressService.determineProgress(100, 200);
        expected = 50;
        assertEquals(expected, actual);
        System.out.println("Finished test verifyCalc");
    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
