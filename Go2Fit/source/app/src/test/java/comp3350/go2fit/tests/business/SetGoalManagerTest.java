package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.SetGoalManager;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.tests.persistence.SetGoalPersistenceStub;

public class SetGoalManagerTest extends TestCase {
    private SetGoalManager setGoalManager = new SetGoalManager(new SetGoalPersistenceStub());
    private SetGoalModel setGoalModel;

    @Test
    public void testForNullObject() {

        System.out.println("\nStarting testSetGoalManager: null object");

        assertNotNull(setGoalManager);
        System.out.println("\nFinished testSetGoalManager: null object");
    }

    @Test
    public void testAddGoal() {
        System.out.println("\nStarting testSetGoalManager: verifying add method");

        setGoalModel = new SetGoalModel("mode", 100, "1200", "period");
        boolean result = setGoalManager.setGoal(setGoalModel);
        assertTrue(result);

        System.out.println("\nFinished testSetGoalManager: verification of add method");
    }

    @Test
    public void testGetGoal() {
        System.out.println("\nStarting testSetGoalManager: verifying get goal method");

        setGoalModel = setGoalManager.getGoal(0);
        assertNotNull(setGoalModel);

        System.out.println("\nFinished testSetGoalManager: verification of get goal method");
    }

}
