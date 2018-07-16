package comp3350.srsys;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go2fit.Application.StartUp;
import comp3350.go2fit.R;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UpdateAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void update() throws Exception
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());


        //selecting toolbar and update option
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Update Profile")).perform(click());


        onView(withId(R.id.username_input)).perform(typeText("testuser1"));
        onView(withId(R.id.password_input)).perform(typeText("7654321"));
        onView(withId(R.id.confirm_password_input)).perform(typeText("7654321"));
        closeSoftKeyboard();
        onView(withText("UPDATE!")).perform(click());

        pressBack();
        pressBack();
        pressBack();

        //logging into Go2Fit
        onView(withId(R.id.username)).perform(clearText(), typeText("testuser1"));
        onView(withId(R.id.password)).perform(clearText(), typeText("7654321"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());
    }
}
