package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.Application.Services;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.PresentationLayer.Messages;

/**User manager**/
public class UserManager implements UserManagerInterface
{
    private UserPersistence userDatabase;

    public UserManager()
    {
        this.userDatabase = Services.getUserPersistence();
    }

    public UserManager(final UserPersistence userPersistence) {
        this.userDatabase = userPersistence;
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
    public boolean addUser(UserModel user){ return this.userDatabase.add(user);}
    public void startChallenge(int id)
    {
        UserModel user = getUser(CurrentUserService.getUserId());
        user.setCurrentChallenge(id);
        user.setChallengeStarted(true);
        updateUser(user);
    }
    public boolean validatePoints(int pointsRequired)
    {
        UserModel userModel = getUser(CurrentUserService.getUserId());

        if(userModel.getTotalPoints() >= pointsRequired)
        {
            return true;
        }
        return false;
    }
}
