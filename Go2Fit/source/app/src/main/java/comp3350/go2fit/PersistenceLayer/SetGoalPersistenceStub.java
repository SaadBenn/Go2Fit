package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class SetGoalPersistenceStub implements SetGoalPersistence{

    private HashMap<Integer, SetGoalModel> setGoals;
    private Integer nextId = 0;

    public SetGoalPersistenceStub()
    {
        setGoals = new HashMap<>();
    }

    public void initializeDatabase()
    {
        SetGoalModel temp = new SetGoalModel("Walking", 1000, "1", "Weekly");
        temp.setId(nextId);
        setGoals.put(temp.getId(), temp);
        nextId++;
    }

    public void addGoal(SetGoalModel model)
    {
        model.setId(nextId);
        setGoals.put(model.getId(), model);
        nextId++;
    }

    public SetGoalModel getGoal(int id)
    {
        return setGoals.get(id);
    }
}
