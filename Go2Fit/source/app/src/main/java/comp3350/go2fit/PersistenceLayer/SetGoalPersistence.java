package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;

public interface SetGoalPersistence {

    public void initializeDatabase();

    public void addGoal(SetGoalModel model);
    public SetGoalModel getGoal(int id);

}

