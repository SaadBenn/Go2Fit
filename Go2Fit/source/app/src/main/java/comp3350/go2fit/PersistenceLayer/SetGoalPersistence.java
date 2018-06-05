package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;

public interface SetGoalPersistence {

    public void initializeDatabase();
    public String[] getPeriod();

    public String[] getTime();

    public Integer[] getSteps();


    public void addgoal(SetGoalModel model);

}

