package comp3350.go2fit.BuisnessLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface AchieveServiceInterface {
    boolean verifyDistance(String distance);
    boolean verifyTime(int hours,int minute);
    ArrayList<String> getAllAchieveNames(LinkedHashMap map);
}
