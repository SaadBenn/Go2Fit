package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.HashMap;

import comp3350.go2fit.Models.ChallengesModel;

public interface ChallengeManagerInterface {
    HashMap getAllChallenges();
    void addChallenge(ChallengesModel challengesModel);
    ChallengesModel getChallenge(int id);
}
