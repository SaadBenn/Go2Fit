package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.SetGoalModel;

public interface SetGoalManagerInterface {
    boolean setgoal(SetGoalModel model);
    SetGoalModel getGoal(int id);
}
