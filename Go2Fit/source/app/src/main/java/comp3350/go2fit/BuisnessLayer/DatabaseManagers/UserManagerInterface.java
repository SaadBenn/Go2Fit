package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;

import comp3350.go2fit.Models.UserModel;

/**User manager interface**/
public interface UserManagerInterface
{
    UserModel getUser(int userId);
    boolean updateUser(UserModel user);
    HashMap getAllUsers();
    void addUser(UserModel user);

}
