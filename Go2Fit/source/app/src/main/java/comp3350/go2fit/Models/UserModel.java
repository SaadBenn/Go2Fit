package comp3350.go2fit.Models;

/**User model**/
public class UserModel
{
    private int     id;
    private int     currentChallengeId;
    private boolean challengeStarted;
    private String  name;
    private String  password;
    private int     totalPoints;
    private double     totalCalories;
    private double     totalDistance;

    public UserModel()
    {
        this.currentChallengeId = 0;
        this.totalPoints = 0;
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

    public String getPassword()
    {
        return this.password;
    }

    public int getTotalPoints()
    {
        return this.totalPoints;
    }

    public double getTotalCalories()
    {
        return this.totalCalories;
    }

    public double getTotalDistance()
    {
        return this.totalDistance;
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

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTotalPoints(int totalPoints)
    {
        this.totalPoints = totalPoints;
    }

    public void setTotalCalories(double totalCalories)
    {
        this.totalCalories = totalCalories;
    }

    public void setTotalDistance(double totalDistance)
    {
        this.totalDistance = totalDistance;
    }
}
