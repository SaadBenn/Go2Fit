package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**set goal persistence stub**/
public class SetGoalPersistenceStub implements SetGoalPersistence
{
    private HashMap<Integer, SetGoalModel> setGoals;
    private Integer nextId = 0;

    public SetGoalPersistenceStub()
    {
        this.setGoals = new HashMap<>();
    }

    public void initializeDatabase()
    {
        SetGoalModel temp = new SetGoalModel("Walking", 1000, "1", "Weekly");
        temp.setId(nextId);
        setGoals.put(temp.getId(), temp);
        nextId++;
    }

    public boolean addGoal(SetGoalModel model)
    {
        boolean result = false;
        model.setId(nextId);
        this.setGoals.put(model.getId(), model);
        result = true;
        nextId++;
        return result;
    }

    public SetGoalModel getGoal(int id)
    {
        return this.setGoals.get(id);
    }
}
