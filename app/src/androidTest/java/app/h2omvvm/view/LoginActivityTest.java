package app.h2omvvm.view;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import app.h2omvvm.R;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Multimedia on 8/5/2018.
 */
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private String nName = "mithran";
    private String nPass = "mithran";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUnderTest(){
//        Espresso.onView(withId(R.id.et)).perform((typeText(nName)));
        Espresso.onView(withId(R.id.login_username)).perform(typeText(nName));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.login_password)).perform(typeText(nPass));
        Espresso.onView(withId(R.id.login_button)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }

}