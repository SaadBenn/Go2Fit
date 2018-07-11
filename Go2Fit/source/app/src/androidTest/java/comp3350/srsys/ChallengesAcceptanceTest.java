package comp3350.srsys;

import android.accessibilityservice.AccessibilityService;
import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class ChallengesAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);

    @Test
    public void ViewChallenges() throws Exception
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());

        //selecting challenges
        onView(withText("CHALLENGES")).perform(click());

        //selecting challenge from the list
        onData(anything()).inAdapterView(withId(R.id.challengesList)).atPosition(0).perform(click());

        //start the challenge
        onView(withId(R.id.button)).perform(click());

        pressBack();
        pressBack();

        //selecting challenges
        onView(withText("CURRENT CHALLENGE")).perform(click());
    }

    @Test
    public void createChallenge() throws Exception
    {

        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());

        //selecting creating challenge
        onView(withText("CHALLENGES")).perform(click());

        //press create challenge button
        onView(withId(R.id.create_challenge)).perform(click());


        onView(withId(R.id.challenge_name)).perform(typeText("Test challenge"));
        onView(withId(R.id.edittext)).perform(typeText("100"));

        closeSoftKeyboard();

        onView(withId(R.id.timePicker1)).perform(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_CENTER, GeneralLocation.BOTTOM_CENTER, Press.FINGER));
        onView(withId(R.id.timePicker)).perform(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_CENTER, GeneralLocation.BOTTOM_CENTER, Press.FINGER));


        //create challenge
        onView(withId(R.id.done_button)).perform(click());

        pressBack();

        //selecting challenges
        onView(withText("HOME")).perform(click());


        onView(withText("CHALLENGES")).perform(click());

        SystemClock.sleep(100);
    }
}
