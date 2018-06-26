package comp3350.go2fit.BuisnessLayer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;

public class ChallengesLeaderBoardsService implements LeaderBoardsServiceInterface, Comparator<UserModel> {

    @Override
    public int compare(UserModel model1, UserModel model2)
    {
        return model2.getChallengesCompleted() - model1.getChallengesCompleted();
    }
}