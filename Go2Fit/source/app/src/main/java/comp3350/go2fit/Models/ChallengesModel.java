package comp3350.go2fit.Models;

import android.os.Parcelable;
import android.os.Parcel;

/**Challenges Model**/
public class ChallengesModel
{
    private String challengeName;
    private String challengeType;
    private long   time;
    private int    stepsRequired;
    private int    points;
    private int    id;

    /**Empty constructor**/
    public  ChallengesModel() { }

    /**Constructor overloading**/
    public ChallengesModel(String challengeName, String challengeType, int stepsRequired, long time, int points)
    {
        this.challengeName = challengeName;
        this.challengeType = challengeType;
        this.stepsRequired = stepsRequired;
        this.time          = time;
        this.points        = points;
    }

    /**Accessors**/
    public String getChallengeName()
    {
        return this.challengeName;
    }

    public String getChallengeType()
    {
        return this.challengeType;
    }

    public int getStepsRequired()
    {
        return this.stepsRequired;
    }

    public long getTime()
    {
        return this.time;
    }

    public int getPoints()
    {
        return this.points;
    }

    public int getId()
    {
        return this.id;
    }

    /**Mutators**/

    public void setChallengeName(String challengeName)
    {
        this.challengeName = challengeName;
    }

    public void setChallengeType(String challengeType)
    {
        this.challengeType = challengeType;
    }

    public void setStepsRequired(int stepsRequired)
    {
        this.stepsRequired = stepsRequired;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
