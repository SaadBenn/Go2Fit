package comp3350.go2fit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go2fit.tests.business.AccessChallengesIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessChallengesIT.class
})
public class IntegrationTests {}
