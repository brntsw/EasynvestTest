package easynvest.bruno.com.easynvesttest.ui.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import easynvest.bruno.com.easynvesttest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
                allOf(withText("Easynvest Test"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Easynvest Test")));

        ViewInteraction appCompatTextView = onView(
                allOf(withText("Contato"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction editText = onView(
                withClassName(is("android.widget.EditText")));
        editText.perform(scrollTo(), replaceText("jshha"), closeSoftKeyboard());

        pressBack();

        ViewInteraction editText2 = onView(
                withClassName(is("android.widget.EditText")));
        editText2.perform(scrollTo(), replaceText("114"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                withText("(11) 4"));
        editText3.perform(scrollTo(), replaceText("(11) 4233"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                withText("(11) 4233-"));
        editText4.perform(scrollTo(), replaceText("(11) 4233-1458"), closeSoftKeyboard());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withText("Gostaria de cadastrar meu email"),
                        withParent(withId(R.id.root))));
        appCompatCheckBox.perform(scrollTo(), click());

        ViewInteraction button = onView(
                allOf(withText("Enviar"),
                        withParent(withId(R.id.root))));
        button.perform(scrollTo(), click());

        ViewInteraction editText5 = onView(
                withClassName(is("android.widget.EditText")));
        editText5.perform(scrollTo(), replaceText("abc@hgah.com"), closeSoftKeyboard());

        pressBack();

        ViewInteraction button2 = onView(
                allOf(withText("Enviar"),
                        withParent(withId(R.id.root))));
        button2.perform(scrollTo(), click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withText("Investimento"), isDisplayed()));
        appCompatTextView2.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
