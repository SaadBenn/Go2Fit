package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.AccessChallenges;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AccessChallengesIT
{
    private AccessChallenges accessChallenges;
    private File tempDB;


    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.accessChallenges = new AccessChallenges();
    }

    @Test
    public void testListChallenges()
    {
        final ChallengesModel challenge;


    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}


