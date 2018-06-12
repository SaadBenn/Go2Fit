package comp3350.go2fit.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ChallengesModelParceable implements Parcelable{

    private ChallengesModel model;

    public ChallengesModelParceable(ChallengesModel model)
    {
        this.model = model;
    }
    protected ChallengesModelParceable(Parcel in)
    {
        model = new ChallengesModel();
        model.setChallengeName(in.readString());
        model.setChallengeType(in.readString());
        model.setStepsRequired(in.readInt());
        model.setTime(in.readLong());
        model.setPoints(in.readInt());
        model.setId(in.readInt());
    }

    public static final Creator<ChallengesModelParceable> CREATOR = new Creator<ChallengesModelParceable>()
    {
        @Override
        public ChallengesModelParceable createFromParcel(Parcel in)
        {
            return new ChallengesModelParceable(in);
        }

        @Override
        public ChallengesModelParceable[] newArray(int size)
        {
            return new ChallengesModelParceable[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model.getChallengeName());
        dest.writeString(model.getChallengeType());
        dest.writeInt(model.getStepsRequired());
        dest.writeLong(model.getTime());
        dest.writeInt(model.getPoints());
        dest.writeInt(model.getId());
    }

    public ChallengesModel getModel() {
        return model;
    }
}
