package comp3350.go2fit.Models;

/**User model**/
public class UserModel
{
    private int     id;
    private int     totalPoints;
    private double     totalDistance;
    private int     currentChallengeId;
    private int     challengesCompleted;
    private boolean challengeStarted;
    private String  name;
    private String  password;
    private double  totalCalories;

    public UserModel()
    {
        this.challengesCompleted = 0;
        this.currentChallengeId  = 0;
        this.totalPoints         = 0;
        this.totalDistance       = 0;
        this.id                  = 0;
        this.challengeStarted    = false;
    }

    /**Accessors**/
    public int getChallengesCompleted()
    {
        return this.challengesCompleted;
    }

    public double getTotalDistance()
    {
        return this.totalDistance;
    }

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

    /**Mutators**/
    public void increaseChallengesCompleted()
    {
        this.challengesCompleted = this.challengesCompleted + 1;
    }

    public void setTotalDistance(int distance)
    {
        this.totalDistance = this.totalDistance + distance;
    }

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


    @Override
    public String toString() {
        return "name: " + this.name + ", total points: "
                + this.totalPoints + ", totalDistance: " + this.totalDistance + ", challenges completed: " + this.challengesCompleted + "\n";
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
