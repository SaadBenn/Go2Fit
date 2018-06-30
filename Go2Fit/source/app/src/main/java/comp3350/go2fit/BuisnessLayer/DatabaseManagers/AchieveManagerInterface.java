package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.Models.ChallengesModel;

/**Challenge manager interface**/
public interface AchieveManagerInterface
{
    AchieveModel getAchieve(int id);

    LinkedHashMap getAllAchieve();
    boolean addAchieve(AchieveModel achieveModel);
}
