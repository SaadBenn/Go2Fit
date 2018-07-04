package comp3350.go2fit.tests.business;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.tests.persistence.ChallengePersistenceStub;

public class ChallengeManagerTest extends TestCase {
    private ChallengeManager challengeManager = new ChallengeManager(new ChallengePersistenceStub());
    private HashMap dict;
    private ChallengesModel model;

    @Test
    public void testForNull() {
        System.out.println("\nStarting ChallengeManagerTest: null database");

        challengeManager = new ChallengeManager(new ChallengePersistenceStub());
        assertNotNull(challengeManager);

        System.out.println("Finished ChallengeManagerTest: null database");
    }

    @Test
    public void testgetProgressForNull() {
        System.out.println("\nStarting ChallengeManagerTest: HashMap check");

        dict = new HashMap();

        dict = challengeManager.getAllChallenges();
        assertTrue(dict instanceof HashMap);
        assertNotNull(dict);

        System.out.println("Finished ChallengeManagerTest: null hash map check");
    }

    @Test
    public void testGetChallenge() {
        model = challengeManager.getChallenge(0);
        assertNotNull(model);
    }

    @Test
    public void testAddChallenge() {
        model = new ChallengesModel("challengeName", "challengeType", 20, 1, 10);
        boolean result = challengeManager.addChallenge(model);
        assertTrue(result);
    }
}
