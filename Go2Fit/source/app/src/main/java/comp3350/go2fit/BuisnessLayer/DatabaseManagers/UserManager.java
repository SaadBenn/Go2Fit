package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.UserPersistence;

public class UserManager implements UserManagerInterface {

    private UserPersistence userDatabase;

    public UserManager()
    {
        userDatabase = Services.getUserPersistence();
    }
    public UserModel getUser(int userId)
    {
        return userDatabase.getUser(userId);
    }
    public void updateUser(UserModel user)
    {
        userDatabase.update(user);
    }

}
