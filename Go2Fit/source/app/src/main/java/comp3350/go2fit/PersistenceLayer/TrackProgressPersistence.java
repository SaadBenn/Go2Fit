package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.TrackProgressModel;

/**track progress persistence interface**/
public interface TrackProgressPersistence
{
    boolean add(TrackProgressModel userProgress);
    boolean update(TrackProgressModel userProgress);
    boolean remove(int id);
    TrackProgressModel getProgress(int userId);
}
