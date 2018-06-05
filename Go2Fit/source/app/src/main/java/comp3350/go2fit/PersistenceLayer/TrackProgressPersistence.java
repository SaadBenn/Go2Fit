package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;
import java.util.List;

import comp3350.go2fit.Models.TrackProgressModel;

public interface TrackProgressPersistence {
    void initializeDatabase();
    void closeStubDatabase();
    void add(final TrackProgressModel progress);
    void update(TrackProgressModel progress);
    TrackProgressModel getProgress(int userId);
    void clearStubDatabase();
}
