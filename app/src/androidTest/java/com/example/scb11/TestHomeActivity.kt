package com.example.scb11

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestHomeActivity {

    @Rule
    @JvmField
    var mActivityScenarioRule: ActivityScenarioRule<HomeActivity> = ActivityScenarioRule(
        HomeActivity::class.java
    )

    @Test
    fun  homeActivityTest() {
        //typring abdul annsari in etContact
        onView(withId(R.id.etContact))
            .perform(typeText("abdul ansari"), closeSoftKeyboard());
        //click button with get
        onView(withId(R.id.btnGet)).perform(click());
        //check if tvHome has abdul ansari in it
        onView(withId(R.id.tvHome))
            .check(matches(withText("abdul ansari")));
    }
}