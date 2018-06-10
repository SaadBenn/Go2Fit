package comp3350.go2fit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// import your test classes
import comp3350.go2fit.business.ProgressManagerTest;
import comp3350.go2fit.business.UserManagerTest;
import comp3350.go2fit.business.ChallengeManagerTest;
import comp3350.go2fit.business.ChallengesServiceTest;
import comp3350.go2fit.business.TrackProgressServiceTest;
import comp3350.go2fit.objects.ChallengesModelTest;
import comp3350.go2fit.objects.TrackProgressModelTest;
import comp3350.go2fit.objects.UserModelTest;
import comp3350.go2fit.business.SetGoalManagerTest;

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
        SetGoalManagerTest.class
})

public class AllTests { }
