package comp3350.go2fit.Models;

import android.widget.Switch;

import java.sql.Time;

public class SetGoalModel {
    private String mode;
    private Integer steps;
    private String time;
    private String period;

    public SetGoalModel(String mode,Integer steps,String time,String period)
    {
        this.mode=mode;
        this.steps=steps;
        this.time=time;
        this.period=period;
    }
    public String getMode() {
        return mode;

    }
    public Integer getSteps()

    {
        return steps;
    }

    public String  getTime()
    {
        return time;
    }
    public String getPeriod()
    {
        return period;
    }



}
