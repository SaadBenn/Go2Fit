package comp3350.go2fit.Models;

public class ChallengesModel
{
    private String challengeName;
    private String challengeType;
    private int stepsRequired;
    private long time;
    private int points;
    private int id;

    public ChallengesModel()
    {

    }

    public ChallengesModel(String challengeName, String challengeType, int stepsRequired, long time, int points)
    {
        this.challengeName = challengeName;
        this.challengeType = challengeType;
        this.stepsRequired = stepsRequired;
        this.time = time;
        this.points = points;
    }
    public void setChallengeName(String challengeName)
    {
        this.challengeName = challengeName;
    }
    public String getChallengeName()
    {
        return challengeName;
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
