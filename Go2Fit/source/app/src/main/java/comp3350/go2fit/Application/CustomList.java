package comp3350.go2fit.Application;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PresentationLayer.Messages;
import comp3350.go2fit.R;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final Integer[] pointsList;
    private Button button;

    public CustomList(Activity context, String[] itemname, Integer[] imgid, Integer[] pointsList) {
        super(context, R.layout.list, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.pointsList = pointsList;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list, null,true);

        final TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        TextView pointsText = (TextView) rowView.findViewById(R.id.textView24);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        pointsText.setText(pointsList[position] + " Points");
        extratxt.setText("You get "+itemname[position]);

        final UserManager userManager = new UserManager();

        button = (Button) rowView.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userManager.validatePoints(pointsList[position]))
                {
                    Messages.notify(context, "Sorry, you dont have enough points to redeem this prize");
                }
                else
                {
                    openModalWindow(itemname[position], pointsList[position]);
                }
            }
        });
        return rowView;

    }

    public void openModalWindow(String title, final int points)
    {
        final UserManager userManager = new UserManager();
        final UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.confirm_prize);

        TextView textView = (TextView) dialog.findViewById(R.id.textView25);

        Button button1 = (Button) dialog.findViewById(R.id.button2);
        Button button2 = (Button) dialog.findViewById(R.id.button4);

        textView.setText("Are you sure you want to redeem " + title.substring(0, title.length()-1) + " for " + points + " points?");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userModel.setTotalPoints(userModel.getTotalPoints() - points);
                userManager.updateUser(userModel);
                dialog.cancel();
                Messages.notify(context, "Congrats, you just redeemed an awesome prize!");
                button.setEnabled(false);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.setTitle("Redeem Prize!");
        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        }
}