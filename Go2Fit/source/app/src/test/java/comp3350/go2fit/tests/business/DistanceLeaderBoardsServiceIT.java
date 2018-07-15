package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.DistanceLeaderBoardsService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertTrue;

public class DistanceLeaderBoardsServiceIT {

    private DistanceLeaderBoardsService leaderBoardsService;
    private File tempDB;
    private UserModel user1;
    private UserModel user2;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.leaderBoardsService = new DistanceLeaderBoardsService();
        this.user1 = new UserModel();
        this.user2 = new UserModel();
    }

    @Test
    public void testForNull() {
        System.out.println("Starting DistanceLeaderBoardsService: check for comparision");

        leaderBoardsService = new DistanceLeaderBoardsService();
        user1.setCurrentChallenge(0);
        user1.setId(1);
        user1.setTotalDistance(300);

        user2.setCurrentChallenge(1);
        user2.setId(2);
        user2.setTotalDistance(400);

        assertTrue("User 2's distance should be more than user1's distance", leaderBoardsService.compare(user1, user2) > 0);

        System.out.println("Finished DistanceLeaderBoardsService: check for comparision");
    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
