package comp3350.go2fit.Models;

import android.widget.Switch;

import java.sql.Time;


/**Set goal model**/
public class SetGoalModel
{
    private String  mode;
    private Integer steps;
    private String  time;
    private String  period;
    private int     id;

    public SetGoalModel(String mode,Integer steps,String time,String period)
    {
        this.mode   = mode;
        this.steps  = steps;
        this.time   = time;
        this.period = period;
    }

    /**Accessors**/
    public String getMode()
    {
        return this.mode;
    }

    public Integer getSteps()
    {
        return this.steps;
    }

    public String  getTime()
    {
        return this.time;
    }

    public String getPeriod()
    {
        return this.period;
    }

    public int getId()
    {
        return this.id;
    }

    /**Mutators**/
    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setPeriod(String period)
    {
        this.period = period;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
