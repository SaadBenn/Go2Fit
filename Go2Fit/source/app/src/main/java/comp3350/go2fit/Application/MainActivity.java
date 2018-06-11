package comp3350.go2fit.Application;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import comp3350.go2fit.R;


/**
 * This app offers three view fragments and three tabs below the app bar
 * to navigate to them, as well as the options menu showing Settings.
 */
public class MainActivity extends AppCompatActivity
{
    /**
     * Creates the content view and toolbar, sets up the tab layout, and sets up a page adapter
     * to manage views in fragments. The user clicks a tab and navigates to the view fragment.
     *
     * @param savedInstanceState Saved instance.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout layout = (TabLayout) findViewById(R.id.tab_layout);

        layout.addTab(layout.newTab().setText(R.string.home));
        layout.addTab(layout.newTab().setText(R.string.challenges));
        layout.addTab(layout.newTab().setText(R.string.current_challenge));
        layout.addTab(layout.newTab().setText("Set Goals"));

        layout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager tabs = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), layout.getTabCount());
        tabs.setAdapter(adapter);
        tabs.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabs.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {
            //nothing to see here...
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {
            //nothing to see here...
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu_main)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu_main);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}