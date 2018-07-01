package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;
import java.util.Map;

import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.Models.ChallengesModel;

/**Challenge manager interface**/
public interface AchieveManagerInterface
{
    AchieveModel getAchieve(int id);

    Map getAllAchieve();
    boolean addAchieve(AchieveModel achieveModel);
}
