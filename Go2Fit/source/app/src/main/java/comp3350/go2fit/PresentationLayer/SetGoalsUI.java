package comp3350.go2fit.PresentationLayer;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.SetGoalManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

/**set goal UI**/
public class SetGoalsUI extends Fragment implements CompoundButton.OnCheckedChangeListener,AdapterView.OnItemSelectedListener
{
    Switch         walk_btn;
    Switch         run_btn;
    String         modeselected;
    Integer        stepselected;
    String         timeselected;
    String         periodselected;
    SetGoalModel   setmodel;
    SetGoalManager setGoalManager;

    public SetGoalsUI()
    {
        setGoalManager = new SetGoalManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.setgoals,container,false);

        Spinner spinner= view.findViewById(R.id.spinner_steps);
        Spinner spinner1=view.findViewById(R.id.spinner_time);
        Spinner spinner2=view.findViewById(R.id.spinnerFor);

        walk_btn = view.findViewById(R.id.switch_Walk);
        run_btn  = view.findViewById(R.id.switch_Run);

        walk_btn.setOnCheckedChangeListener(this);
        run_btn.setOnCheckedChangeListener(this);

        SetGoalModel model = setGoalManager.getGoal(0);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        timeselected = "1 hour";

        setmodel = new SetGoalModel(modeselected,stepselected,timeselected,periodselected);

        Button setgoalbt = view.findViewById(R.id.setgoalbtn);

        setgoalbt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                UserManager userManager = new UserManager();
                UserModel model = userManager.getUser(2);
                setGoalManager.setGoal(setmodel);

                Messages.notify(getActivity(), "Your goal has been set!" +
                        "");
            }
        });

        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {
        modeselected = modeselected(walk_btn,run_btn);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        if(adapterView.getItemAtPosition(i) instanceof Integer)
        {
            stepselected = (Integer)adapterView.getItemAtPosition(i);
        }
        else
        {
            if(adapterView.getItemAtPosition(i) instanceof String)
            {
                periodselected = (String) adapterView.getItemAtPosition(i);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public String modeselected(Switch one,Switch two)
    {
        String result = "";

        if(one.isChecked())
        {
            two.setChecked(false);
            result = "walk";
        }
        else
        {
            if(two.isChecked())
            {
                one.setChecked(false);
                result = "Run";
            }
        }
        return result;
    }
}

