package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.TrackProgressModel;

/**Progress manager interface**/
public interface ProgressManagerInterface
{
    TrackProgressModel getProgress(int userId);
    boolean            updateDatabase(TrackProgressModel progress);
    boolean            remove(int id);
}
