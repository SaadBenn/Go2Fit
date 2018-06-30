package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.Map;

import comp3350.go2fit.Models.ChallengesModel;

/**Challenge manager interface**/
public interface ChallengeManagerInterface
{
    Map<Integer, ChallengesModel>         getAllChallenges();
    ChallengesModel getChallenge(int id);
    boolean         addChallenge(ChallengesModel challengesModel);
}
