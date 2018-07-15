package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.Map;

import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.Models.UserModel;

/**User manager interface**/
public interface UserManagerInterface
{
    UserModel getUser(int userId);
    boolean updateUser(UserModel user);
    Map<Integer, UserModel> getAllUsers();
    boolean addUser(UserModel user);
    boolean startChallenge(int id);
    boolean validatePoints(int pointsRequired);
    boolean completedChallenge(TrackProgressModel model);
    boolean failedChallenge();

}
