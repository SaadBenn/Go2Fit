package comp3350.go2fit.Models;

public class ChallengesModel
{
    private String challengeType;
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

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
}
