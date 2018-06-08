package comp3350.go2fit.business;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.ChallengesService;

public class ChallengesServiceTest extends TestCase {

    private ChallengesService challengeService = new ChallengesService();
    private boolean result;
    //private ArrayList<String> aList = new ArrayList<>();
   // private HashMap dict = new HashMap();


     @Test
     public void testVerification()
     {

     	System.out.println("\nStarting testChallengeServices: verification");

     	result = challengeService.verifyDistance("20");
     	assertTrue(result);

     	result = challengeService.verifyTime(2, 20);
     	assertTrue(result);

     	System.out.println("Finished testChallengeServices: verification");
     }

    @Test
    public void testPointsLogic() {
        System.out.println("\nStarting testChallengeServices: check for the correctness of points");

        int points = challengeService.determinePoints(100, 100);
        int expectedPoints = ((100 * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(100)));
        assertEquals(expectedPoints, points);

        System.out.println("Finished testChallengeServices: check for the correctness of points");
    }
}
