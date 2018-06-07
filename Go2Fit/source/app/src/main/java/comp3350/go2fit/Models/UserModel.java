package comp3350.go2fit.Models;

public class UserModel {
    private int currentChallengeId;
    private String name;
    private boolean challengeStarted;
    private int id;

    public UserModel()
    {
        currentChallengeId = 0;
        challengeStarted = false;
        id = 0;
    }

    public void setCurrentChallenge(int currentChallengeId)
    {
        this.currentChallengeId = currentChallengeId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getCurrentChallenge()
    {
        return currentChallengeId;
    }
    public String getName()
    {
        return name;
    }

    public void setChallengeStarted(boolean challengeStarted)
    {
        this.challengeStarted = challengeStarted;
    }

    public boolean getChallengeStarted() {
        return challengeStarted;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}
