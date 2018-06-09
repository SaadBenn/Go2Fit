package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;

public class SetGoalManager {
    SetGoalPersistence db;

    public SetGoalManager()
    {
        db = Services.getSetGoalPersistence();
    }

    public void setgoal(SetGoalModel model)
    {
        db.addGoal(model);
    }
    public SetGoalModel getGoal(int id)
    {
        return db.getGoal(id);
    }

}
