package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;

public class ProgressManager {
    TrackProgressPersistence database;

    public ProgressManager()
    {
        database = Services.getTrackProgressPersistence();
    }

    public TrackProgressModel getProgress(int userId) throws NullPointerException
    {
        return database.getProgress(userId);
    }

    public void updateDatabase(TrackProgressModel progress)
    {
        database.update(progress);
    }

    public void addProgress(TrackProgressModel progress)
    {
        database.add(progress);
    }

}
