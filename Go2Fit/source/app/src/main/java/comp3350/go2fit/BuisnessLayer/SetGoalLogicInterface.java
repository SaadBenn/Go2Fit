package comp3350.go2fit.BuisnessLayer;

import comp3350.go2fit.Models.SetGoalModel;
import android.widget.Switch;

public interface SetGoalLogicInterface {
    Object[] getData();
    String modeSelected(Switch one,Switch two);
    void setGoal(SetGoalModel model);
}
