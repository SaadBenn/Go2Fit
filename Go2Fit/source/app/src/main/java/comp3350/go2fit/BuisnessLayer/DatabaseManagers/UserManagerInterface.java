package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.Map;

import comp3350.go2fit.Models.UserModel;

/**User manager interface**/
public interface UserManagerInterface
{
    UserModel getUser(int userId);
    boolean updateUser(UserModel user);
    Map<Integer, UserModel> getAllUsers();
    boolean addUser(UserModel user);
    void startChallenge(int id);
    boolean validatePoints(int pointsRequired);


}
