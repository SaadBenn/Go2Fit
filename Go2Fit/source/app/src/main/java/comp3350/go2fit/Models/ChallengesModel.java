package comp3350.go2fit.Models;

import android.os.Parcelable;
import android.os.Parcel;

public class ChallengesModel implements Parcelable
{
    private String challengeType;
    private int id;

    public ChallengesModel()
    {

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

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
}
