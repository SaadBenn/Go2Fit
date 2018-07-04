package comp3350.go2fit.tests.objects;

import junit.framework.TestCase;

import comp3350.go2fit.Models.ChallengesModel;
import org.junit.Test;

public class ChallengesModelTest extends TestCase {

    @Test
    public void testChallengesModel1()
    {
        ChallengesModel challengesModel;
        ChallengesModel challengesModel1;

        challengesModel1 = new ChallengesModel("Running", "Hard", 3000, 20, 100);
        assertNotNull(challengesModel1);

        System.out.println("\nStarting testChallengesModel");

        challengesModel = new ChallengesModel();

        // test for valid data
        System.out.println("Testing valid data in the ChallengesModel class.");
        challengesModel.setChallengeType("Walking");
        assertTrue(challengesModel.getChallengeType() instanceof String);
        System.out.println("ChallengeType is of type string in ChallengesModel class");

        assertNotNull(challengesModel.getChallengeType());
        assertEquals("Walking", challengesModel.getChallengeType());

        challengesModel.setStepsRequired(20);
        assertEquals(20, challengesModel.getStepsRequired());

        challengesModel.setId(1);
        challengesModel.setTime(1200);

        assertEquals(1, challengesModel.getId());
        assertEquals(1200, challengesModel.getTime());

        // test for null object
        assertNotNull(challengesModel);
        System.out.println("challengesModel object is not null");

        // test invalid data
        System.out.println("Testing invalid data in the ChallengesModel class.");
        assertNotSame(0, challengesModel.getId());

        System.out.println("Finished testChallengesModel");
    }
}
