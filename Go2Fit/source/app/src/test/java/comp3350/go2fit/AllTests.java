package comp3350.go2fit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// import your test classes
import comp3350.go2fit.business.ProgressManagerTest;
import comp3350.go2fit.business.UserManagerTest;
import comp3350.go2fit.business.ChallengeManagerTest;
import comp3350.go2fit.business.ChallengesServiceTest;
import comp3350.go2fit.business.TrackProgressServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        // TODO
        ProgressManagerTest.class,
        UserManagerTest.class,
        ChallengeManagerTest.class,
        ChallengesServiceTest.class,
        TrackProgressServiceTest.class
})

public class AllTests { }
