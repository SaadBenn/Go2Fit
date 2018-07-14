package comp3350.go2fit.BuisnessLayer;

import java.util.List;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

public class AccessChallenges
{
    private ChallengePersistence  challengePersistence;
    private List<ChallengesModel> challenges;
    private ChallengesModel       challenge;
    private int                   currentChallenge;


    public AccessChallenges()
    {
        challengePersistence = Services.getChallengePersistence();
        challenges           = null;
        challenge            = null;
        currentChallenge     = 0;
    }

    public AccessChallenges(final ChallengePersistence challengePersistence)
    {
        this();
        this.challengePersistence = challengePersistence;
    }

    public List<ChallengesModel> getChallenges()
    {
        return null;
    }
}
