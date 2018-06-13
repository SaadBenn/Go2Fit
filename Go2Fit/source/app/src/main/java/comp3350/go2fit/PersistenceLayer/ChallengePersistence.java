package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.ChallengesModel;

/**Challenge persistence interface**/
public interface ChallengePersistence
{
    void clearStubDatabase();
    void closeStubDatabase();
    void initializeDatabase();
    boolean add(final ChallengesModel progress);
    ChallengesModel getChallenge(int userId);
    LinkedHashMap getAllChallenges();
}
