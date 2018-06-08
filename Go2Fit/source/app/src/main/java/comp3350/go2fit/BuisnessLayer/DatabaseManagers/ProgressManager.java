package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;

public class ProgressManager implements ProgressManagerInterface {
    TrackProgressPersistence database;

    public ProgressManager()
    {
        database = Services.getTrackProgressPersistence();
    }

    public TrackProgressModel getProgress(int userId) throws NullPointerException
    {
        return database.getProgress(userId);
    }

    public boolean updateDatabase(TrackProgressModel progress)
    {
        boolean result = database.update(progress);
        return result;
    }
    public boolean addProgress(TrackProgressModel progress)
    {
        boolean result = database.add(progress);
        return result;
    }

}
