package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.AchieveManager;
import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.tests.persistence.AchievePersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class AchieveManagerIT {
    private File tempDB;
    private AchieveManager achieveManager;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.achieveManager = new AchieveManager(new AchievePersistenceStub());
        this.achieveManager = new AchieveManager();
    }

    @Test
    public void testForNull() {
        System.out.println("\nStarting AchieveManagerTest: check for null");
        assertNotNull(achieveManager);
        System.out.println("Finished AchieveManagerTest: check for null");
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
        this.achieveManager = new AchieveManager(new AchievePersistenceStub());
        this.achieveManager = new AchieveManager();
    }


    @Test
    public void testForGetAchieve() {
        System.out.println("Starting AchieveManagerTest: check for getAchieve");

        AchieveModel achieveModel = achieveManager.getAchieve(0);
        assertNotNull(achieveModel);

        System.out.println("Finished AchieveManagerTest: check for getAchieve");

        System.out.println("Starting AchieveManagerTest: check for getAllAchieve");

        LinkedHashMap<Integer, AchieveModel> map = achieveManager.getAllAchieve();

        assertNotNull(map);
        assertTrue(map.size() >= 1);

        System.out.println("Finished AchieveManagerTest: check for getAllAchieve");

        System.out.println("Starting AchieveManagerTest: check for addChallenge");
        AchieveModel achieve1 = new AchieveModel();

        achieve1.setAchieveName("Monster Steps");
        achieve1.setAchieveType("fghj");
        achieve1.setStepsRequired(500);
        achieve1.setTime(345678);
        achieve1.setId(4);

        assertTrue(achieveManager.addChallenge(achieve1));
        assertFalse(achieveManager.addAchieve(achieve1));

        System.out.println("Finished AchieveManagerTest: check for addChallenge");
    }


    @After
    public void tearDown1()
    {
        //reset DB
        this.tempDB.delete();
    }
}
