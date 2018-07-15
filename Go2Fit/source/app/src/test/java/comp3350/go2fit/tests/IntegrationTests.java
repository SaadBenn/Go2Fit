package comp3350.go2fit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go2fit.tests.business.AchieveManagerIT;
import comp3350.go2fit.tests.business.AchieveServiceIT;
import comp3350.go2fit.tests.business.ChallengeManagerIT;
import comp3350.go2fit.tests.business.ChallengesLeaderBoardsServiceIT;
import comp3350.go2fit.tests.business.ChallengesServiceIT;
import comp3350.go2fit.tests.business.DistanceLeaderBoardsServiceIT;
import comp3350.go2fit.tests.business.PasswordServiceIT;
import comp3350.go2fit.tests.business.PointsLeaderBoardsServiceIT;
import comp3350.go2fit.tests.business.PrizesManagerIT;
import comp3350.go2fit.tests.business.ProgressManagerIT;
import comp3350.go2fit.tests.business.SetGoalManagerIT;
import comp3350.go2fit.tests.business.TrackProgressServiceIT;
import comp3350.go2fit.tests.business.UserManagerIT;
import comp3350.go2fit.tests.business.UserServiceIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AchieveManagerIT.class,
        AchieveServiceIT.class,
        ChallengeManagerIT.class,
        ChallengesLeaderBoardsServiceIT.class,
        ChallengesServiceIT.class,
        DistanceLeaderBoardsServiceIT.class,
        PasswordServiceIT.class,
        PointsLeaderBoardsServiceIT.class,
        PrizesManagerIT.class,
        ProgressManagerIT.class,
        SetGoalManagerIT.class,
        TrackProgressServiceIT.class,
        UserManagerIT.class,
        UserServiceIT.class
})
public class IntegrationTests {}
