package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.PointsLeaderBoardsService;
import comp3350.go2fit.Models.UserModel;

public class PointsLeaderBoardsServiceTest extends TestCase {

    private PointsLeaderBoardsService leaderBoardsService;
    private UserModel user1;
    private UserModel user2;

    @Test
    public void testForNull() {
        System.out.println("Starting PointsLeaderBoardsService: check for comparision");

        leaderBoardsService = new PointsLeaderBoardsService();
        user1 = new UserModel();
        user1.setCurrentChallenge(0);
        user1.setId(1);
        user1.setTotalPoints(300);

        user2 = new UserModel();
        user2.setCurrentChallenge(1);
        user2.setId(2);
        user2.setTotalPoints(400);

        assertTrue("User 2's points should be more than user1's points", leaderBoardsService.compare(user1, user2) > 0);

        System.out.println("Finished PointsLeaderBoardsService: check for comparision");
    }
}
