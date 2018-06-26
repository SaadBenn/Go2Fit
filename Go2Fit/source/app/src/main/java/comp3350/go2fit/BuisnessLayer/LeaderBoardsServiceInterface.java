package comp3350.go2fit.BuisnessLayer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.Models.ChallengesModelParceable;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;

public interface LeaderBoardsServiceInterface
{
    int compare(UserModel m1, UserModel m2);
}
