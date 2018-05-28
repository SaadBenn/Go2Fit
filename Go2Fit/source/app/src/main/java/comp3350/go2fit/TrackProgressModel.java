package comp3350.go2fit;

public class TrackProgressModel {
    private int numSteps;
    private int percentageComplete;
    private double distance;
    private double userWeight;

    public TrackProgressModel()
    {
        numSteps = 0;
        percentageComplete = 0;
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

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public double getUserWeight() {
        return userWeight;
    }
}
