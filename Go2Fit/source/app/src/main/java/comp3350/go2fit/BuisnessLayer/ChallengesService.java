package comp3350.go2fit.BuisnessLayer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.Models.ChallengesModel;


/**Challenges service**/
public class ChallengesService implements ChallengesServiceInterface
{
    public boolean verifyDistance(String distance) throws NumberFormatException
    {
        Integer.parseInt(distance);
        return true;
    }

    public boolean verifyTime(int hours, int minutes)
    {
        if(hours <= 0 && minutes <= 0)
        {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int determinePoints(int steps, long time)
    {
        return ((steps * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(time)));
    }

    public ArrayList<String> getAllChallengeNames(LinkedHashMap map)
    {
        Set<Integer> set = map.keySet();
        ArrayList<String> values = new ArrayList<>();
        for(Integer value : set)
        {
            ChallengesModel model = (ChallengesModel)map.get(value);
            values.add(model.getChallengeName());
        }
        return values;
    }
}
