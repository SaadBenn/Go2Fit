package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.PrizesManager;
import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.tests.persistence.PrizesPersistenceStub;

public class PrizesManagerTest extends TestCase {
    private PrizesManager db = new PrizesManager(new PrizesPersistenceStub());

    @Test
    public void testForNull() {
        System.out.println("Starting PrizesManager: null database test");
        assertNotNull(db);
        System.out.println("Finished PrizesManager: null database test");
    }

    @Test
    public void testGetAllPrizes() {
        System.out.println("Starting PrizesManager: getAllPrizes test");
        HashMap<Integer, PrizesModel> prizes;

        prizes = (HashMap<Integer, PrizesModel>) db.getAllPrizes();
        assertNotNull(prizes);

        assertTrue("Size of the HashMap is > 0", prizes.size() > 0);

        System.out.println("Finished PrizesManager: getAllPrizes test");
    }
}
