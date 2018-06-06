package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.ChallengesModel;

public interface ChallengePersistence {
    void initializeDatabase();
    void closeStubDatabase();
    void add(final ChallengesModel progress);
    String getChallengeType(int userId);
    String getChallengeName(int userId);
    ChallengesModel getChallenge(int userId);
    HashMap getAllChallenges();
    void clearStubDatabase();
}
