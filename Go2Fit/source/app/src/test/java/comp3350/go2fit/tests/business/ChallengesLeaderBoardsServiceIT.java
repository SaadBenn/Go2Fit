package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.ChallengesLeaderBoardsService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertTrue;

public class ChallengesLeaderBoardsServiceIT {

    private ChallengesLeaderBoardsService leaderBoardsService;
    private File tempDB;
    private UserModel user1;
    private UserModel user2;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.leaderBoardsService = new ChallengesLeaderBoardsService();
        user1 = new UserModel();
        user2 = new UserModel();
    }

    @Test
    public void testForNull() {
        System.out.println("Starting ChallengesLeaderBoardsService: check for comprision");

        leaderBoardsService = new ChallengesLeaderBoardsService();

        user1.setCurrentChallenge(0);
        user1.setId(1);
        user1.increaseChallengesCompleted();

        user2.setCurrentChallenge(1);
        user2.setId(2);
        user2.increaseChallengesCompleted();
        user2.increaseChallengesCompleted();
        user2.increaseChallengesCompleted();

        assertTrue("User 2 should have more challenges completed", leaderBoardsService.compare(user1, user2) > 0);

        System.out.println("Finished ChallengesLeaderBoardsService: check for comparision");
    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }
}
