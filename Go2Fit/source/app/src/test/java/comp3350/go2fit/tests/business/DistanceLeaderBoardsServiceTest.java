package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.DistanceLeaderBoardsService;
import comp3350.go2fit.Models.UserModel;

public class DistanceLeaderBoardsServiceTest extends TestCase {

    private DistanceLeaderBoardsService leaderBoardsService;
    private UserModel user1;
    private UserModel user2;

    @Test
    public void testForNull() {
        System.out.println("Starting DistanceLeaderBoardsService: check for comparision");

        leaderBoardsService = new DistanceLeaderBoardsService();
        user1 = new UserModel();
        user1.setCurrentChallenge(0);
        user1.setId(1);
        user1.setTotalDistance(300);

        user2 = new UserModel();
        user2.setCurrentChallenge(1);
        user2.setId(2);
        user2.setTotalDistance(400);

        assertTrue("User 2's distance should be more than user1's distance", leaderBoardsService.compare(user1, user2) > 0);

        System.out.println("Finished DistanceLeaderBoardsService: check for comparision");
    }
}
