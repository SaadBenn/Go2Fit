package comp3350.go2fit.BuisnessLayer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**Challenges Service Interface**/
public interface ChallengesServiceInterface
{
    boolean verifyDistance(String distance);
    boolean verifyTime(int hours, int minutes);
    int     determinePoints(int steps, long time);
    ArrayList<String> getAllChallengeNames(LinkedHashMap map);
}
