package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.LinkedHashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.AchieveManager;
import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.tests.persistence.AchievePersistenceStub;

public class AchieveManagerTest extends TestCase {
    private AchieveManager achieveManager;

    @Test
    public void testForNull() {
        System.out.println("\nStarting AchieveManagerTest: check for null");
        achieveManager = new AchieveManager(new AchievePersistenceStub());
        assertNotNull(achieveManager);
        System.out.println("Finished AchieveManagerTest: check for null");
    }

    @Test
    public void testForGetAchieve() {
        System.out.println("Starting AchieveManagerTest: check for getAchieve");

        AchieveModel achieve1 = new AchieveModel();

        achieve1.setAchieveName("Baby Steps");
        achieve1.setAchieveType("speed");
        achieve1.setStepsRequired(5);
        achieve1.setTime(876543);
        achieve1.setId(0);
        achieveManager = new AchieveManager(new AchievePersistenceStub());
        achieveManager.addAchieve(achieve1);

        AchieveModel achieveModel = achieveManager.getAchieve(0);
        assertNotNull(achieveModel);

        System.out.println("Finished AchieveManagerTest: check for getAchieve");
    }

    @Test
    public void testForGetAllAchieve() {
        System.out.println("Starting AchieveManagerTest: check for getAllAchieve");

        AchieveModel achieve1 = new AchieveModel();

        achieve1.setAchieveName("Baby Steps");
        achieve1.setAchieveType("speed");
        achieve1.setStepsRequired(5);
        achieve1.setTime(876543);
        achieve1.setId(0);
        achieveManager = new AchieveManager(new AchievePersistenceStub());
        achieveManager.addAchieve(achieve1);

        LinkedHashMap<Integer, AchieveModel> map = achieveManager.getAllAchieve();

        assertNotNull(map);
        assertTrue(map.size() >= 1);

        System.out.println("Finished AchieveManagerTest: check for getAllAchieve");
    }

    @Test
    public void testForAddChallenge() {

        System.out.println("Starting AchieveManagerTest: check for addChallenge");
        AchieveModel achieve1 = new AchieveModel();

        achieve1.setAchieveName("Baby Steps");
        achieve1.setAchieveType("speed");
        achieve1.setStepsRequired(5);
        achieve1.setTime(876543);
        achieve1.setId(0);

        achieveManager = new AchieveManager(new AchievePersistenceStub());
        assertTrue(achieveManager.addChallenge(achieve1));

        System.out.println("Finished AchieveManagerTest: check for addChallenge");
    }
}
