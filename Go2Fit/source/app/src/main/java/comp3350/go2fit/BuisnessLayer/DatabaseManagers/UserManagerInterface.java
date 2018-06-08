package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.UserModel;

public interface UserManagerInterface {
    UserModel getUser(int userId);
    void updateUser(UserModel user);
}
