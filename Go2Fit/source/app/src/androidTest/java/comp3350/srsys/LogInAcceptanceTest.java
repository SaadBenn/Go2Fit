package comp3350.srsys;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go2fit.Application.StartUp;
import comp3350.go2fit.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LogInAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void logIn()
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());
    }
}
