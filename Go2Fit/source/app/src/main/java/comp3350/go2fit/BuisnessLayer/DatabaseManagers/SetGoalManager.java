package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;

public class SetGoalManager implements SetGoalManagerInterface {
    SetGoalPersistence db;

    public SetGoalManager()
    {
        db = Services.getSetGoalPersistence();
    }

    public boolean setgoal(SetGoalModel model)
    {
        return db.addGoal(model);
    }
    public SetGoalModel getGoal(int id)
    {
        return db.getGoal(id);
    }

}
