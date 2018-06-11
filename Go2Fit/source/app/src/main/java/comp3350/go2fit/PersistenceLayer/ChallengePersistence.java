package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.ChallengesModel;

/**Challenge persistence interface**/
public interface ChallengePersistence
{
    void clearStubDatabase();
    void closeStubDatabase();
    void initializeDatabase();
    boolean add(final ChallengesModel progress);
    String getChallengeType(int userId);
    String getChallengeName(int userId);
    ChallengesModel getChallenge(int userId);
    HashMap getAllChallenges();
}
