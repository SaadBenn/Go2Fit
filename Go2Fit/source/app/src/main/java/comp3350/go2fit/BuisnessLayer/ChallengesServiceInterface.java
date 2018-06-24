package comp3350.go2fit.BuisnessLayer;

import java.util.List;
import java.util.LinkedHashMap;

/**Challenges Service Interface**/
public interface ChallengesServiceInterface
{
    boolean verifyDistance(String distance);
    boolean verifyTime(int hours, int minutes);
    int     determinePoints(int steps, long time);
    List<String> getAllChallengeNames(LinkedHashMap map);
}
