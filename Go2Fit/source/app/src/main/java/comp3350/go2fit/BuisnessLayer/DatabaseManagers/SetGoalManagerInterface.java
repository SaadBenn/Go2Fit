package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Models.SetGoalModel;

/**Set goal interface**/
public interface SetGoalManagerInterface
{
    boolean      setGoal(SetGoalModel model);
    SetGoalModel getGoal(int id);
}
