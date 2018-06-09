package comp3350.go2fit.BuisnessLayer;

import comp3350.go2fit.Models.SetGoalModel;
import android.widget.Switch;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;

public class SetGoalLogic
{
    SetGoalPersistence db;

    public SetGoalLogic()
    {
        db = Services.getSetGoalPersistence();
    }

    public Object[] getData()
    {

        Object [] data=new Object[5];
        data[0]=db.getSteps();
        data[1]=db.getTime();
        data[2]=db.getPeriod();

        return data;
    }

    public String modeselected(Switch one,Switch two)
    {
        String result="";
        if(one.isChecked())
        {
            two.setChecked(false);
            result="walk";
        }
        else
        {
            if(two.isChecked())
            {
                one.setChecked(false);
                result="Run";
            }
        }
        return result;
    }
}
