package comp3350.go2fit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go2fit.tests.business.AchieveManagerTest;
import comp3350.go2fit.tests.business.AchieveServiceTest;
import comp3350.go2fit.tests.business.ChallengeManagerTest;
import comp3350.go2fit.tests.business.ChallengesLeaderBoardsServiceTest;
import comp3350.go2fit.tests.business.ChallengesServiceTest;
import comp3350.go2fit.tests.business.DistanceLeaderBoardsServiceTest;
import comp3350.go2fit.tests.business.PasswordServiceTest;
import comp3350.go2fit.tests.business.PointsLeaderBoardsServiceTest;
import comp3350.go2fit.tests.business.PrizesManagerTest;
import comp3350.go2fit.tests.business.ProgressManagerTest;
import comp3350.go2fit.tests.business.SetGoalManagerTest;
import comp3350.go2fit.tests.business.TrackProgressServiceTest;
import comp3350.go2fit.tests.business.UserManagerTest;
import comp3350.go2fit.tests.business.UserServiceTest;
import comp3350.go2fit.tests.objects.ChallengesModelTest;
import comp3350.go2fit.tests.objects.TrackProgressModelTest;
import comp3350.go2fit.tests.objects.UserModelTest;
// import your test classes



@RunWith(Suite.class)
@Suite.SuiteClasses({

        ProgressManagerTest.class,
        UserManagerTest.class,
        ChallengeManagerTest.class,
        ChallengesServiceTest.class,
        TrackProgressServiceTest.class,
        ChallengesModelTest.class,
        TrackProgressModelTest.class,
        UserModelTest.class,
        SetGoalManagerTest.class,
        PrizesManagerTest.class,
        ChallengesLeaderBoardsServiceTest.class,
        DistanceLeaderBoardsServiceTest.class,
        PointsLeaderBoardsServiceTest.class,
        UserServiceTest.class,
        PasswordServiceTest.class,
        AchieveManagerTest.class,
        AchieveServiceTest.class
})

public class AllTests { }
