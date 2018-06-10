package comp3350.go2fit.Models;

import android.widget.Switch;

import java.sql.Time;

public class SetGoalModel {
    private String mode;
    private Integer steps;
    private String time;
    private String period;
    private int id;

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
    public void setSteps(int steps)
    {
        this.steps = steps;
    }
    public Integer getSteps()

    {
        return steps;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
    public String  getTime()
    {
        return time;
    }

    public void setPeriod(String period)
    {
        this.period = period;
    }
    public String getPeriod()
    {
        return period;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }


}
