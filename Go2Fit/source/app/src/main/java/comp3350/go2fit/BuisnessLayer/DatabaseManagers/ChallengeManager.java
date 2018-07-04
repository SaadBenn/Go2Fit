package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;
import java.util.LinkedHashMap;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

/**Challenge Manager **/
public class ChallengeManager implements ChallengeManagerInterface
{
    private ChallengePersistence challengesDatabase;

    public ChallengeManager()
    {
        this.challengesDatabase = Services.getChallengePersistence();
    }

    public ChallengeManager(final ChallengePersistence challengePersistence) {
        this.challengesDatabase = challengePersistence;
    }

    public LinkedHashMap<Integer, ChallengesModel> getAllChallenges() throws NullPointerException
    {
        return (LinkedHashMap<Integer, ChallengesModel>)this.challengesDatabase.getAllChallenges();
    }

    public ChallengesModel getChallenge(int id) throws NullPointerException
    {
        return this.challengesDatabase.getChallenge(id);
    }

    public boolean addChallenge(ChallengesModel challengesModel)
    {
        return this.challengesDatabase.add(challengesModel);
    }
}
