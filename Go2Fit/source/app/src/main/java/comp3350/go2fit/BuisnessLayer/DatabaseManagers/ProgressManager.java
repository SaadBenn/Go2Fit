package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;

/**Progress Manager**/
public class ProgressManager implements ProgressManagerInterface
{
    TrackProgressPersistence database;

    public ProgressManager()
    {
        this.database = Services.getTrackProgressPersistence();
    }

    public ProgressManager(final TrackProgressPersistence trackProgressPersistence) {
        this.database = trackProgressPersistence;
    }

    public TrackProgressModel getProgress(int userId) throws NullPointerException
    {
        return this.database.getProgress(userId);
    }

    public boolean updateDatabase(TrackProgressModel progress)
    {
        return this.database.update(progress);
    }

    public boolean addProgress(TrackProgressModel progress)
    {
        return this.database.add(progress);
    }

    public boolean remove(int id)
    {
        return this.database.remove(id);
    }
}
