package comp3350.go2fit.Models;

public class TrackProgressModel {
    private int numSteps;
    private int percentageComplete;
    private double distance;
    private double calories;
    private int id;
    private int userId;
    public TrackProgressModel()
    {
        numSteps = 0;
        percentageComplete = 0;
        distance = 0;
        calories = 0;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setNumSteps(int numSteps)
    {
        this.numSteps = numSteps;
    }

    public int getNumSteps()
    {
        return this.numSteps;
    }

    public void setPercentageComplete(int percentageComplete)
    {
        this.percentageComplete = percentageComplete;
    }

    public int getPercentageComplete()
    {
        return this.percentageComplete;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setCalories(double calories)
    {
        this.calories = calories;
    }

    public double getCalories()
    {
        return calories;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public int getUserId()
    {
        return userId;
    }
}
