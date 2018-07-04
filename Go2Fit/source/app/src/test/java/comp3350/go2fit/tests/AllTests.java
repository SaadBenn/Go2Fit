package comp3350.go2fit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// import your test classes
import comp3350.go2fit.tests.business.ProgressManagerTest;
import comp3350.go2fit.tests.business.UserManagerTest;
import comp3350.go2fit.tests.business.ChallengeManagerTest;
import comp3350.go2fit.tests.business.ChallengesServiceTest;
import comp3350.go2fit.tests.business.TrackProgressServiceTest;
import comp3350.go2fit.tests.objects.ChallengesModelTest;
import comp3350.go2fit.tests.objects.TrackProgressModelTest;
import comp3350.go2fit.tests.objects.UserModelTest;
import comp3350.go2fit.tests.business.SetGoalManagerTest;

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
