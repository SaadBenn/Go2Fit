package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ChallengesServiceIT extends TestCase {

    private ChallengesService challengeService;
    private File tempDB;
    private boolean result;
    private ChallengesModel model1;
    private ChallengesModel model2;
    private ChallengesModel model3;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.challengeService = new ChallengesService();
        this.model1 = new ChallengesModel();
        this.model2 = new ChallengesModel();
        this.model3 = new ChallengesModel();
    }


    @Test
    public void testVerification()
    {
        System.out.println("\nStarting testChallengeServices: verification");
        result = challengeService.verifyDistance("20");
        assertTrue(result);

        result = challengeService.verifyTime(2, 20);
        assertTrue(result);
        System.out.println("Finished testChallengeServices: verification");

        System.out.println("\nStarting testChallengeServices: check for the correctness of points");
        int points = challengeService.determinePoints(100, 100);
        int expectedPoints = ((100 * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(100)));
        assertEquals(expectedPoints, points);
        System.out.println("Finished testChallengeServices: check for the correctness of points");


        System.out.println("Starting testGetAllChallengeNames: check for correct names");
        LinkedHashMap<Integer, ChallengesModel> testMap = new LinkedHashMap<>();


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
        this.challengeService = new ChallengesService();
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

    @After
    public void tearDown1()
    {
        //reset DB
        this.tempDB.delete();
    }
}
