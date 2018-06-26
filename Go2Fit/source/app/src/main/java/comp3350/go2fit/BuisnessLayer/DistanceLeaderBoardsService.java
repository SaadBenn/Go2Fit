package comp3350.go2fit.BuisnessLayer;

import java.util.Comparator;

import comp3350.go2fit.Models.UserModel;

public class DistanceLeaderBoardsService implements LeaderBoardsServiceInterface, Comparator<UserModel>
{
    @Override
    public int compare(UserModel model1, UserModel model2)
    {
        return model2.getTotalDistance() - model1.getTotalDistance();
    }
}
