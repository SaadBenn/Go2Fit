package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;
import java.util.Map;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.UserPersistence;

/**User manager**/
public class UserManager implements UserManagerInterface
{
    private UserPersistence userDatabase;

    public UserManager()
    {
        this.userDatabase = Services.getUserPersistence();
    }
    public UserModel getUser(int userId)
    {
        return this.userDatabase.getUser(userId);
    }
    public boolean updateUser(UserModel user)
    {
        return this.userDatabase.update(user);
    }
    public Map<Integer, UserModel> getAllUsers(){ return this.userDatabase.getAllUsers(); }
    public void addUser(UserModel user){ this.userDatabase.add(user);}
}
