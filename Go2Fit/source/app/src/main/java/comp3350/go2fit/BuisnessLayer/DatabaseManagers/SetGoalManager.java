package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;

/**Set goal manager**/
public class SetGoalManager implements SetGoalManagerInterface
{
    SetGoalPersistence db;

    public SetGoalManager()
    {
        this.db = Services.getSetGoalPersistence();
    }

    public boolean setGoal(SetGoalModel model)
    {
        return this.db.addGoal(model);
    }

    public SetGoalModel getGoal(int id)
    {
        return this.db.getGoal(id);
    }
}
