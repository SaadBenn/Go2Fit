package comp3350.go2fit.Models;

public class ChallengesModel
{
    private String challengeType;
    private int stepsRequired;
    private long time;
    private int points;
    private int id;

    public ChallengesModel()
    {

    }

    public void setChallengeType(String challengeType)
    {
        this.challengeType = challengeType;
    }
    public String getChallengeType()
    {
        return challengeType;
    }

    public void setStepsRequired(int stepsRequired)
    {
        this.stepsRequired = stepsRequired;
    }
    public int getStepsRequired()
    {
        return this.stepsRequired;
    }

    public void setTime(long time)
    {
        this.time = time;
    }
    public long getTime()
    {
        return time;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }
    public int getPoints()
    {
        return points;
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
