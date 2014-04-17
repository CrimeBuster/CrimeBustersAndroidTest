package com.illinoiscrimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.test.ActivityInstrumentationTestCase2;

import com.crime.crimebusters.R;
import com.illinoiscrimebusters.crimebusters.LoginActivity;

public class LoginActivityUiTest 
	extends ActivityInstrumentationTestCase2<LoginActivity> {

	public LoginActivityUiTest() {
		super(LoginActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		getActivity();
	}
	
	@Override
	public void tearDown() throws Exception {
		SharedPreferences preference = 
				PreferenceManager.getDefaultSharedPreferences(getActivity());
		preference.edit().putBoolean("isAuthenticated", false).commit();
		super.tearDown();
	}
	
	public void testLogin() { 
		onView(withId(R.id.email)).perform(typeText("crime.buster"));
		onView(withId(R.id.password)).perform(typeText("test123"));
		
		onView(withId(R.id.sign_in_button)).perform(click());

		onView(withId(R.id.report_button))
			.check(matches(withText(containsString("Report"))));
	}
	
	public void testLoginWithEmptyUserName() {
		onView(withId(R.id.password)).perform(typeText("test123"));
		
		onView(withId(R.id.sign_in_button)).perform(click())
			.check(matches(withText("Log in")));
	}
	
	public void testLoginWithEmptyPassword() {
		onView(withId(R.id.email)).perform(typeText("crime.buster"));
		
		onView(withId(R.id.sign_in_button)).perform(click())
			.check(matches(withText("Log in")));
	}
}
