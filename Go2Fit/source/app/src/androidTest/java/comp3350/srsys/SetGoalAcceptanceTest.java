package comp3350.srsys;

import android.os.SystemClock;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go2fit.Application.StartUp;
import comp3350.go2fit.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;


@RunWith(AndroidJUnit4.class)
public class SetGoalAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void setGoal()
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());

        //selecting challenges
        onView(withText("SET GOALS")).perform(click());

        onView(withId(R.id.spinner_steps)).perform(click());
        onData(anything()).atPosition(1).perform(click());

        onView(withId(R.id.spinner_time)).perform(click());
        onData(anything()).atPosition(2).perform(click());

        onView(withId(R.id.spinnerFor)).perform(click());
        onData(anything()).atPosition(2).perform(click());


        onView(withId(R.id.switch_Walk)).perform(click());
        onView(withId(R.id.setgoalbtn)).perform(click());

        SystemClock.sleep(300);
        pressBack();
    }
}
