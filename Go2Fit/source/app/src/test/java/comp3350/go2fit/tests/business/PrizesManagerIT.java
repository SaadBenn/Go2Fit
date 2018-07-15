package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.PrizesManager;
import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.tests.persistence.PrizesPersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class PrizesManagerIT {
    private PrizesManager db;
    private File tempDB;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new PrizesManager(new PrizesPersistenceStub());
        this.db = new PrizesManager();
    }


    @Test
    public void testForNull() {
        System.out.println("Starting PrizesManager: null database test");
        assertNotNull(db);
        System.out.println("Finished PrizesManager: null database test");

        System.out.println("Starting PrizesManager: getAllPrizes test");
        HashMap<Integer, PrizesModel> prizes;

        prizes = (HashMap<Integer, PrizesModel>) db.getAllPrizes();
        assertNotNull(prizes);

        assertTrue("Size of the HashMap is > 0", prizes.size() > 0);

        System.out.println("Finished PrizesManager: getAllPrizes test");
    }


    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
