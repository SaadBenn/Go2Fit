package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PresentationLayer.Messages;

/**Progress Manager**/
public class ProgressManager implements ProgressManagerInterface
{
    TrackProgressPersistence database;

    public ProgressManager()
    {
        this.database = Services.getTrackProgressPersistence();
    }

    public ProgressManager(final TrackProgressPersistence trackProgressPersistence) {
        this.database = trackProgressPersistence;
    }

    public TrackProgressModel getProgress(int userId) throws NullPointerException
    {
        return this.database.getProgress(userId);
    }

    public boolean updateDatabase(TrackProgressModel progress)
    {
        return this.database.update(progress);
    }

    public boolean addProgress(TrackProgressModel progress)
    {
        return this.database.add(progress);
    }

    public boolean remove(int id)
    {
        return this.database.remove(id);
    }

    public void completedChallenge(TrackProgressModel progressModel)
    {
        UserManager userManager = new UserManager();
        ChallengeManager challengeManager = new ChallengeManager();
        ProgressManager progressManager = new ProgressManager();
        UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

        userModel.setChallengeStarted(false);
        userModel.setTotalPoints(userModel.getTotalPoints() + challengeManager.getChallenge(userModel.getCurrentChallenge()).getPoints());
        userModel.increaseChallengesCompleted();

        userModel.setTotalCalories(userModel.getTotalCalories() + progressModel.getCalories());
        userModel.setTotalDistance(userModel.getTotalDistance() + progressModel.getDistance());

        //Messages.notify(getActivity(), "Awesome Job! You completed the challenge!");

        progressManager.remove(CurrentUserService.getUserId());
        userManager.updateUser(userModel);
        //timer.cancel();
        //sensorManager.unregisterListener(this);
    }

    public void failedChallenge()
    {
        UserManager userManager = new UserManager();
        ProgressManager progressManager = new ProgressManager();

        UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

        userModel.setChallengeStarted(false);

        //Messages.notify(getActivity(), "Oops! You didnt complete the challenge on time...");

        progressManager.remove(CurrentUserService.getUserId());
        userManager.updateUser(userModel);
        //timer.cancel();
        //sensorManager.unregisterListener(this);
    }

}
