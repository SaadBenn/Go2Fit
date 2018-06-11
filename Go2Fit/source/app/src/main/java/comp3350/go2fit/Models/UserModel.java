package comp3350.go2fit.Models;

/**User model**/
public class UserModel
{
    private int     id;
    private int     currentChallengeId;
    private boolean challengeStarted;
    private String  name;

    public UserModel()
    {
        this.currentChallengeId = 0;
        this.challengeStarted   = false;
        this.id = 0;
    }

    /**Accessors**/
    public int getCurrentChallenge()
    {
        return this.currentChallengeId;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getChallengeStarted()
    {
        return this.challengeStarted;
    }

    public int getId()
    {
        return this.id;
    }

    /**Mutators**/
    public void setCurrentChallenge(int currentChallengeId)
    {
        this.currentChallengeId = currentChallengeId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void setChallengeStarted(boolean challengeStarted)
    {
        this.challengeStarted = challengeStarted;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
