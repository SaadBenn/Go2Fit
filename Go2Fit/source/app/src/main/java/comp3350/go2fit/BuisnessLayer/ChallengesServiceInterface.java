package comp3350.go2fit.BuisnessLayer;

import java.util.HashMap;
import java.util.ArrayList;

public interface ChallengesServiceInterface {
    void verifyDistance(String distance);
    void verifyTime(int hours, int minutes);
    int determinePoints(int steps, long time);
    ArrayList<String> getAllChallengeNames(HashMap map);
}
