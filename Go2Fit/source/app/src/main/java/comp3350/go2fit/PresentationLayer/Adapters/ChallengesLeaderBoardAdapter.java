package comp3350.go2fit.PresentationLayer.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class ChallengesLeaderBoardAdapter extends ArrayAdapter<UserModel>
{
    private static final String TAG = "ChallengesLeaderBoardAdapter";

    private Context context;
    private int     resource;

    public ChallengesLeaderBoardAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserModel> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        String name       = getItem(position).getName();
        int numChallenges = getItem(position).getChallengesCompleted();
        int pos           = position + 1;

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView             = inflater.inflate(this.resource, parent, false);

        TextView tvName       = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvChallenges = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvPos        = (TextView) convertView.findViewById(R.id.textView3);

        tvName.setText(name);
        tvChallenges.setText("challenges completed: " + Integer.toString(numChallenges));
        tvPos.setText("Rank: " + Integer.toString(pos));

        return convertView;
    }
}
