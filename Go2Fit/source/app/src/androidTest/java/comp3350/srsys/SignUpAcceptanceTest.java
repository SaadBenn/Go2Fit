package comp3350.srsys;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go2fit.Application.StartUp;
import comp3350.go2fit.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;


@RunWith(AndroidJUnit4.class)
public class SignUpAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void signUp() throws Exception
    {

        //press on sign up button
        onView(withId(R.id.textView11)).perform(click());

        onView(withId(R.id.username_input)).perform(typeText("testuser"));
        onView(withId(R.id.password_input)).perform(typeText("1234567"));
        onView(withId(R.id.confirm_password_input)).perform(typeText("1234567"));

        closeSoftKeyboard();

        onView(withId(R.id.sign_up_button)).perform(click());

        pressBack();
        pressBack();

        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("testuser"));
        onView(withId(R.id.password)).perform(typeText("1234567"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());
    }
}
