package comp3350.go2fit.tests.business;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.Models.ChallengesModel;

public class ChallengesServiceTest extends TestCase {

    private ChallengesService challengeService = new ChallengesService();
    private boolean result;


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


    @Test (expected = IllegalArgumentException.class)
    public void testForVerifyTime() {

        System.out.println("\nStarting testChallengeServices: check for IllegalArgumentException");
        try {
            result = challengeService.verifyTime(0, -20);
        } catch (IllegalArgumentException e) {
            assert true;
        }

        System.out.println("Finished testChallengeServices: check for IllegalArgumentException");

    }


    @Test
    public void testPointsLogic() {
        System.out.println("\nStarting testChallengeServices: check for the correctness of points");

        int points = challengeService.determinePoints(100, 100);
        int expectedPoints = ((100 * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(100)));
        assertEquals(expectedPoints, points);

        System.out.println("Finished testChallengeServices: check for the correctness of points");
    }

    @Test
    public void testGetAllChallengeNames(){
        System.out.println("Starting testGetAllChallengeNames: check for correct names");

        LinkedHashMap<Integer, ChallengesModel> testMap = new LinkedHashMap<>();
        ChallengesModel model1 = new ChallengesModel();
        ChallengesModel model2 = new ChallengesModel();
        ChallengesModel model3 = new ChallengesModel();

        model1.setChallengeName("challenge1");
        model2.setChallengeName("challenge2");
        model3.setChallengeName("challenge3");

        testMap.put(0, model1);
        testMap.put(1, model2);
        testMap.put(2, model3);

        ArrayList testList = challengeService.getAllChallengeNames(testMap);
        ArrayList expected = new ArrayList();
        expected.add("challenge1");
        expected.add("challenge2");
        expected.add("challenge3");

        assertEquals(testList, expected);

        System.out.println("Finished testGetAllChallengeNames: check for correct names");
    }
}
