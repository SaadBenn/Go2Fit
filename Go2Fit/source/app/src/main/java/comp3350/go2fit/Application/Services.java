package comp3350.go2fit.Application;

import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.PersistenceLayer.ChallengePersistenceStub;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistenceStub;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.PersistenceLayer.UserPersistenceStub;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistenceStub;

/**Services Class**/

public class Services
{
    private static ChallengePersistence challengePersistence = null;
    private static TrackProgressPersistence trackProgressPersistence = null;
    private static UserPersistence userPersistence = null;
    private static SetGoalPersistence setGoalPersistence = null;

    public static synchronized ChallengePersistence getChallengePersistence()
    {
        if (challengePersistence == null)
        {
            challengePersistence = new ChallengePersistenceStub();
            challengePersistence.initializeDatabase();
        }

        return challengePersistence;
    }

    public static synchronized TrackProgressPersistence getTrackProgressPersistence()
    {
        if (trackProgressPersistence == null)
        {
            trackProgressPersistence = new TrackProgressPersistenceStub();
            trackProgressPersistence.initializeDatabase();
        }

        return trackProgressPersistence;
    }

    public static synchronized UserPersistence getUserPersistence()
{
    if(userPersistence == null)
    {
        userPersistence = new UserPersistenceStub();
        userPersistence.initializeDatabase();
    }

    return userPersistence;
}
    public static synchronized SetGoalPersistence getSetGoalPersistence()
    {
        if(setGoalPersistence == null)
        {
            setGoalPersistence = new SetGoalPersistenceStub();
            setGoalPersistence.initializeDatabase();
        }

        return setGoalPersistence;
    }
}
