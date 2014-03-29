package com.crime.crimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

import com.crime.crimebusters.R;
import com.crime.crimebusters.RegisterUserActivity;

import android.test.ActivityInstrumentationTestCase2;

public class RegisterUserActivityUiTest
	extends ActivityInstrumentationTestCase2<RegisterUserActivity> {

	public RegisterUserActivityUiTest() {
		super(RegisterUserActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		getActivity();
	}
	
	public void testLogin() { 
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click());

		onView(withId(R.id.sign_in_button)).check(matches(withText("Log in")));
	}
}
