package comp3350.go2fit.Application;

import comp3350.go2fit.PersistenceLayer.AchievePersistence;
import comp3350.go2fit.PersistenceLayer.AchievePersistenceStub;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;
import comp3350.go2fit.PersistenceLayer.PrizesPersistence;
import comp3350.go2fit.PersistenceLayer.PrizesPersistenceStub;
import comp3350.go2fit.PersistenceLayer.hsqldb.ChallengePersistenceHSQLDB;
import comp3350.go2fit.PersistenceLayer.hsqldb.PrizesPersistenceHSQLDB;
import comp3350.go2fit.PersistenceLayer.hsqldb.SetGoalPersistenceHSQLDB;
import comp3350.go2fit.PersistenceLayer.hsqldb.TrackProgressPersistenceHSQLDB;
import comp3350.go2fit.PersistenceLayer.hsqldb.UserPersistenceHSQLDB;

/**Services Class**/

public class Services
{
    private static ChallengePersistence challengePersistence = null;
    private static TrackProgressPersistence trackProgressPersistence = null;
    private static UserPersistence userPersistence = null;
    private static SetGoalPersistence setGoalPersistence = null;
    private static PrizesPersistence prizesPersistence = null;
    private static AchievePersistence achievePersistence = null;


    public static synchronized ChallengePersistence getChallengePersistence()
    {
        if (challengePersistence == null)
        {
            //challengePersistence = new ChallengePersistenceStub();
            //challengePersistence.initializeDatabase();
            challengePersistence = new ChallengePersistenceHSQLDB(Main.getDBPathName());
        }

        return challengePersistence;
    }

    public static synchronized TrackProgressPersistence getTrackProgressPersistence()
    {
        if (trackProgressPersistence == null)
        {
            //trackProgressPersistence = new TrackProgressPersistenceStub();
            //trackProgressPersistence.initializeDatabase();
            trackProgressPersistence = new TrackProgressPersistenceHSQLDB(Main.getDBPathName());
        }

        return trackProgressPersistence;
    }

    public static synchronized UserPersistence getUserPersistence()
    {
        if(userPersistence == null)
        {
            //userPersistence = new UserPersistenceStub();
            //userPersistence.initializeDatabase();
            userPersistence = new UserPersistenceHSQLDB(Main.getDBPathName());
        }

        return userPersistence;
    }


    public static synchronized SetGoalPersistence getSetGoalPersistence()
    {
        if(setGoalPersistence == null)
        {
            //setGoalPersistence = new SetGoalPersistenceStub();
            //setGoalPersistence.initializeDatabase();
            setGoalPersistence = new SetGoalPersistenceHSQLDB(Main.getDBPathName());
        }

        return setGoalPersistence;
    }

    public static synchronized PrizesPersistence getPrizesPersistence() {
        if (prizesPersistence == null) {
            //prizesPersistence = new PrizesPersistenceStub();
            //prizesPersistence.initializeDatabase();
            prizesPersistence = new PrizesPersistenceHSQLDB(Main.getDBPathName());
        }

        return prizesPersistence;
    }
    public  static synchronized AchievePersistence  getAchievePersistence(){
        if(achievePersistence==null){
            achievePersistence = new AchievePersistenceStub();
            achievePersistence.initializeDatabase();
        }

        return achievePersistence;
    }
}
