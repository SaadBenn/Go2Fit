package comp3350.go2fit.BuisnessLayer;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.Application.Services;


public class ChallengesService
{
    private ChallengePersistence challengesDatabase;
    public ChallengesService()
    {
        challengesDatabase = Services.getChallengePersistence();
    }
    public void selectChallenge(ListView listView)
    {

    }

    public HashMap getAllChallenges()
    {
        return challengesDatabase.getAllChallenges();
    }

    public void addChallenge(ChallengesModel challengesModel)
    {
        challengesDatabase.add(challengesModel);
    }

    public ArrayList<String> getAllChallengeTypes(HashMap map)
    {
        Set<Integer> set=map.keySet();

        ArrayList<String> values = new ArrayList<>();
        int count = 0;
        for(Integer value : set)
        {
            ChallengesModel model = (ChallengesModel)map.get(value);
            values.add(model.getChallengeType());
            count++;
        }
        return values;
    }


}
