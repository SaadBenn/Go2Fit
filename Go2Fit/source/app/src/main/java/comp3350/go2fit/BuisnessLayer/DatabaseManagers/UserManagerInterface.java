package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.UserModel;

/**User manager interface**/
public interface UserManagerInterface
{
    UserModel getUser(int userId);
    boolean updateUser(UserModel user);
}
