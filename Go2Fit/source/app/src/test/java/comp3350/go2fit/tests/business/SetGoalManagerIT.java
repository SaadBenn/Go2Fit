package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.SetGoalManager;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.tests.persistence.SetGoalPersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class SetGoalManagerIT {
    private File tempDB;
    private SetGoalManager setGoalManager;
    private SetGoalModel setGoalModel;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.setGoalManager = new SetGoalManager(new SetGoalPersistenceStub());
        this.setGoalManager = new SetGoalManager();
    }


    @Test
    public void tests() {

        System.out.println("\nStarting testSetGoalManager: null object");

        assertNotNull(setGoalManager);
        System.out.println("\nFinished testSetGoalManager: null object");

        System.out.println("\nStarting testSetGoalManager: verifying add method");

        setGoalModel = new SetGoalModel("mode", 100, "1200", "period");
        boolean result = setGoalManager.setGoal(setGoalModel);
        assertTrue(result);
        System.out.println("\nFinished testSetGoalManager: verification of add method");

        System.out.println("\nStarting testSetGoalManager: verifying get goal method");
        setGoalModel = setGoalManager.getGoal(0);
        assertNotNull(setGoalModel);
        System.out.println("\nFinished testSetGoalManager: verification of get goal method");
    }


    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
