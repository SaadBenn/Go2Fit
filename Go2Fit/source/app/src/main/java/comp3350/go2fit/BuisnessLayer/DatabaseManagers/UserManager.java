package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.Map;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.Application.Services;

import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.TrackProgressModel;
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
    public boolean startChallenge(int id)
    {
        System.out.println(CurrentUserService.getUserId());
        UserModel user = getUser(CurrentUserService.getUserId());
        user.setCurrentChallenge(id);
        user.setChallengeStarted(true);
        updateUser(user);

        return true;
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

    public boolean completedChallenge(TrackProgressModel progressModel)
    {
        ChallengeManager challengeManager = new ChallengeManager();
        ProgressManager progressManager = new ProgressManager();
        UserModel userModel = getUser(CurrentUserService.getUserId());

        userModel.setChallengeStarted(false);
        userModel.setTotalPoints(userModel.getTotalPoints() + challengeManager.getChallenge(userModel.getCurrentChallenge()).getPoints());
        userModel.increaseChallengesCompleted();

        userModel.setTotalCalories(userModel.getTotalCalories() + progressModel.getCalories());
        userModel.setTotalDistance(userModel.getTotalDistance() + progressModel.getDistance());

        //Messages.notify(getActivity(), "Awesome Job! You completed the challenge!");

        //progressManager.remove(CurrentUserService.getUserId());
        updateUser(userModel);
        //timer.cancel();
        //sensorManager.unregisterListener(this);

        return true;
    }

    public boolean failedChallenge()
    {
        ProgressManager progressManager = new ProgressManager();

        UserModel userModel = getUser(CurrentUserService.getUserId());

        userModel.setChallengeStarted(false);

        updateUser(userModel);

        return true;
    }
}
