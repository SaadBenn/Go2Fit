package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;

public interface SetGoalPersistence {

    void initializeDatabase();

    boolean addGoal(SetGoalModel model);
    SetGoalModel getGoal(int id);

}

