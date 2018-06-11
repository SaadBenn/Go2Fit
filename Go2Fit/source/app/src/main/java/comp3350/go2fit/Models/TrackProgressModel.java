package comp3350.go2fit.Models;

/**Track progress model**/
public class TrackProgressModel
{
    private double distance;
    private double calories;
    private int    id;
    private int    userId;
    private int    numSteps;
    private int    percentageComplete;

    public TrackProgressModel()
    {
        this.percentageComplete = 0;
        this.numSteps = 0;
        this.distance = 0;
        this.calories = 0;
    }

    /**Accessors**/
    public int getId()
    {
        return this.id;
    }

    public int getNumSteps()
    {
        return this.numSteps;
    }

    public int getPercentageComplete()
    {
        return this.percentageComplete;
    }

    public double getDistance()
    {
        return distance;
    }

    public double getCalories()
    {
        return calories;
    }

    public int getUserId()
    {
        return userId;
    }

    /**Mutators**/
    public void setId(int id)
    {
        this.id = id;
    }

    public void setNumSteps(int numSteps)
    {
        this.numSteps = numSteps;
    }

    public void setPercentageComplete(int percentageComplete)
    {
        this.percentageComplete = percentageComplete;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void setCalories(double calories)
    {
        this.calories = calories;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
}
