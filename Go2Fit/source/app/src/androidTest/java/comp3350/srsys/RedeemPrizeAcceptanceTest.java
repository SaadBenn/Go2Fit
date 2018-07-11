package comp3350.srsys;


import android.os.SystemClock;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go2fit.Application.StartUp;
import comp3350.go2fit.R;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class RedeemPrizeAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void redeem()
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());

        //selecting toolbar and leaderboard option
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Redeem Prizes")).perform(click());

        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(0).onChildView(withId(R.id.button3)).perform(click());

        SystemClock.sleep(100);
        pressBack();

        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(1).onChildView(withId(R.id.button3)).perform(click());

        SystemClock.sleep(400);
        //redeeming prize
        onView(withText("REDEEM!")).perform(click());
        pressBack();
        pressBack();
    }
}
