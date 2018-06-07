package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

public class ChallengeManager {
    private ChallengePersistence challengesDatabase;

    public ChallengeManager()
    {
        challengesDatabase = Services.getChallengePersistence();
    }

    public HashMap getAllChallenges() throws NullPointerException
    {
        return challengesDatabase.getAllChallenges();
    }

    public void addChallenge(ChallengesModel challengesModel)
    {
        challengesDatabase.add(challengesModel);
    }

    public ChallengesModel getChallenge(int id) throws NullPointerException
    {
        return challengesDatabase.getChallenge(id);
    }

}
