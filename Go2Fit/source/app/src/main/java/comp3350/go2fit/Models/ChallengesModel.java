package comp3350.go2fit.Models;

import android.os.Parcelable;
import android.os.Parcel;

public class ChallengesModel implements Parcelable
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

    protected ChallengesModel(Parcel in) {
        challengeType = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(challengeType);
        dest.writeInt(id);
    }

    public void setChallengeName(String challengeName)
    {
        this.challengeName = challengeName;
    }
    public String getChallengeName()
    {
        return challengeName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChallengesModel> CREATOR = new Creator<ChallengesModel>() {
        @Override
        public ChallengesModel createFromParcel(Parcel in) {
            return new ChallengesModel(in);
        }

        @Override
        public ChallengesModel[] newArray(int size) {
            return new ChallengesModel[size];
        }
    };

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
