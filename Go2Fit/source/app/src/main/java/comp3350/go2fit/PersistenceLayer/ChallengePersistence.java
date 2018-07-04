package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;
import java.util.Map;

import comp3350.go2fit.Models.ChallengesModel;

/**Challenge persistence interface**/
public interface ChallengePersistence
{
    boolean add(final ChallengesModel progress);
    ChallengesModel getChallenge(int userId);
    Map<Integer, ChallengesModel> getAllChallenges();
}
