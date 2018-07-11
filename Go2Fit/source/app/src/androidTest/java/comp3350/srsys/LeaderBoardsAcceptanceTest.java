package comp3350.srsys;


import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
public class LeaderBoardsAcceptanceTest
{
    //this is where the test will start running (in the StartUp activity)
    @Rule
    public ActivityTestRule<StartUp> activityRule = new ActivityTestRule<>(StartUp.class);


    @Test
    public void viewLeaderBoards() throws Exception
    {
        //logging into Go2Fit
        onView(withId(R.id.username)).perform(typeText("s"));
        onView(withId(R.id.password)).perform(typeText("a"));
        closeSoftKeyboard();
        onView(withId(R.id.start_button)).perform(click());

        //selecting toolbar and leaderboard option
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Leaderboards")).perform(click());

        //selecting points
        onView(withId(R.id.points)).perform(click());
        pressBack();

        //selecting distance
        onView(withId(R.id.distance)).perform(click());
        pressBack();

        //selecting challenges
        onView(withId(R.id.challenges)).perform(click());
        pressBack();

        pressBack();
    }
}
