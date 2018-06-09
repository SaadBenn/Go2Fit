package comp3350.go2fit.PresentationLayer;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.SetGoalManager;
import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.BuisnessLayer.SetGoalLogic;
import comp3350.go2fit.R;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

public class SetGoalsUI extends Fragment implements CompoundButton.OnCheckedChangeListener,AdapterView.OnItemSelectedListener
{

    Switch walk_btn;
    Switch run_btn;
    SetGoalModel setmodel;
    SetGoalLogic logicclass;
    SetGoalManager setGoalManager;
    String modeselected;
    Integer stepselected;
    String timeselected;
    String periodselected;
    Button setgoalbt;

    public SetGoalsUI()
    {
        logicclass=new SetGoalLogic();
        setGoalManager = new SetGoalManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.setgoals,container,false);


        Spinner spinner= view.findViewById(R.id.spinner_steps);
        Spinner spinner1=view.findViewById(R.id.spinner_time);
        Spinner spinner2=view.findViewById(R.id.spinnerFor);

        walk_btn=view.findViewById(R.id.switch_Walk);
        run_btn=view.findViewById(R.id.switch_Run);

        walk_btn.setOnCheckedChangeListener(this);
        run_btn.setOnCheckedChangeListener(this);

        Object[] data=logicclass.getData();




        ArrayAdapter<Integer> stepsview=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,(Integer[])data[0]);
        ArrayAdapter<String> timeview=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,(String[])data[1]);
        ArrayAdapter<String> periodview=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,(String[])data[2]);


        stepsview.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        timeview.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        periodview.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(timeview);
        spinner.setAdapter(stepsview);
        spinner2.setAdapter(periodview);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        timeselected="1 hour";

        setmodel=new SetGoalModel(modeselected,stepselected,timeselected,periodselected);

        setgoalbt=view.findViewById(R.id.setgoalbtn);

        setgoalbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                setGoalManager.setgoal(setmodel);

            }
        });

        return view;

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {
        modeselected=logicclass.modeselected(walk_btn,run_btn);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        if(adapterView.getItemAtPosition(i) instanceof Integer)
        {
            stepselected=(Integer)adapterView.getItemAtPosition(i);
        }
        else
        {
            if(adapterView.getItemAtPosition(i) instanceof String)
            {
                periodselected=(String) adapterView.getItemAtPosition(i);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

