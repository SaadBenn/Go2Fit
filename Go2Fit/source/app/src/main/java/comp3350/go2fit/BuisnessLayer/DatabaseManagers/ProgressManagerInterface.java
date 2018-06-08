package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.TrackProgressModel;

public interface ProgressManagerInterface {
    TrackProgressModel getProgress(int userId);
    boolean updateDatabase(TrackProgressModel progress);
}
