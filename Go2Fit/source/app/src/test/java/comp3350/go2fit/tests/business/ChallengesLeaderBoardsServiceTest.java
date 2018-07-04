package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.ChallengesLeaderBoardsService;
import comp3350.go2fit.Models.UserModel;

public class ChallengesLeaderBoardsServiceTest extends TestCase {

    private ChallengesLeaderBoardsService leaderBoardsService;
    private UserModel user1;
    private UserModel user2;

    @Test
    public void testForNull() {
        System.out.println("Starting ChallengesLeaderBoardsService: check for comprision");

        leaderBoardsService = new ChallengesLeaderBoardsService();
        user1 = new UserModel();
        user1.setCurrentChallenge(0);
        user1.setId(1);
        user1.increaseChallengesCompleted();

        user2 = new UserModel();
        user2.setCurrentChallenge(1);
        user2.setId(2);
        user2.increaseChallengesCompleted();
        user2.increaseChallengesCompleted();
        user2.increaseChallengesCompleted();

        assertTrue("User 2 should have more challenges completed", leaderBoardsService.compare(user1, user2) > 0);

        System.out.println("Finished ChallengesLeaderBoardsService: check for comparision");
    }
}
