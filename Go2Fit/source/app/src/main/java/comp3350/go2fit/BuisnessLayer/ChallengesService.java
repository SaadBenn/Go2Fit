package comp3350.go2fit.BuisnessLayer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.Models.ChallengesModel;

public class ChallengesService implements ChallengesServiceInterface
{
    public void verifyDistance(String distance) throws NumberFormatException
    {
        Integer.parseInt(distance);
    }

    public void verifyTime(int hours, int minutes)
    {
        if(hours <= 0 && minutes <= 0)
        {
            throw new IllegalArgumentException("Time cannot be 0!");
        }
    }

    public int determinePoints(int steps, long time)
    {
        return ((steps * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(time)));
    }

    public ArrayList<String> getAllChallengeNames(HashMap map)
    {
        Set<Integer> set=map.keySet();
        ArrayList<String> values = new ArrayList<>();
        int count = 0;
        for(Integer value : set)
        {
            ChallengesModel model = (ChallengesModel)map.get(value);
            values.add(model.getChallengeName());
            count++;
        }
        return values;
    }

}
