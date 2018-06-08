package comp3350.go2fit.business;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;

public class ChallengeManagerTest extends TestCase {
    private ChallengeManager challengeManager = new ChallengeManager();
    private HashMap dict;

    @Test
    public void testForNull() {
        System.out.println("\nStarting ChallengeManagerTest: null database");

        challengeManager = new ChallengeManager();
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


}
