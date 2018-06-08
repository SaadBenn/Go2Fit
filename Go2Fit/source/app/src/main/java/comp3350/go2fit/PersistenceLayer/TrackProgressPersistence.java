package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.TrackProgressModel;

public interface TrackProgressPersistence {
    void initializeDatabase();
    void closeStubDatabase();
    boolean add(TrackProgressModel userProgress);
    boolean update(TrackProgressModel userProgress);
    TrackProgressModel getProgress(int userId);
    void clearStubDatabase();
}
