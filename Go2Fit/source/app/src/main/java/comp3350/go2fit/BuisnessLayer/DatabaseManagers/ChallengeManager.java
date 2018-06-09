package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

public class ChallengeManager implements ChallengeManagerInterface {
    private ChallengePersistence challengesDatabase;

    public ChallengeManager()
    {
        challengesDatabase = Services.getChallengePersistence();
    }

    public HashMap getAllChallenges() throws NullPointerException
    {
        return challengesDatabase.getAllChallenges();
    }

    public boolean addChallenge(ChallengesModel challengesModel)
    {
        return challengesDatabase.add(challengesModel);
    }

    public ChallengesModel getChallenge(int id) throws NullPointerException
    {
        return challengesDatabase.getChallenge(id);
    }

}
