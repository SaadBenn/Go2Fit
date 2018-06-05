package comp3350.go2fit.PersistenceLayer;

import comp3350.go2fit.Models.SetGoalModel;
import java.sql.Time;
import java.util.ArrayList;

public class SetGoalPersistenceStub implements SetGoalPersistence{

    private String[] period;
    private Integer[] steps;
    private String[] time;
    private ArrayList<SetGoalModel> goalset;

    public SetGoalPersistenceStub()
    {

    }

    public void initializeDatabase()
    {
        period=new String[]{"Today","Weekly","Monthly"};
        steps=new Integer[]{1000,2000,3000};
        time=new String[]{"1 hour","2 hours"};
        goalset=new ArrayList<SetGoalModel>();
    }

    public String[] getPeriod()
    {
        return period;
    }
    public String[] getTime() {
        return time;
    }
    public Integer[] getSteps()
    {
        return steps;
    }

    public void addgoal(SetGoalModel model)
    {
        goalset.add(model);
    }
}
