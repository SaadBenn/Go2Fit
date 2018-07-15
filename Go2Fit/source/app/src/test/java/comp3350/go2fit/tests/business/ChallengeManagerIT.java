package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.tests.persistence.ChallengePersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class ChallengeManagerIT {
    private File tempDB;
    private HashMap dict;
    private ChallengesModel model;
    private ChallengeManager challengeManager;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.challengeManager = new ChallengeManager(new ChallengePersistenceStub());
        this.challengeManager = new ChallengeManager();
    }

    @Test
    public void testForNull() {
        System.out.println("\nStarting ChallengeManagerTest: null database");
        assertNotNull(challengeManager);
        System.out.println("Finished ChallengeManagerTest: null database");

        System.out.println("\nStarting ChallengeManagerTest: HashMap check");
        dict = new HashMap();
        dict = challengeManager.getAllChallenges();
        assertTrue(dict instanceof HashMap);
        assertNotNull(dict);
        System.out.println("Finished ChallengeManagerTest: null hash map check");

        model = challengeManager.getChallenge(0);
        assertNotNull(model);

        model = new ChallengesModel("challengeName", "challengeType", 20, 1, 10);
        boolean result = challengeManager.addChallenge(model, "100", 10000);
        assertTrue(result);

    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
