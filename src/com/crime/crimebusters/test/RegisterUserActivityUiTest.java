package com.crime.crimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

import com.crime.crimebusters.R;
import com.crime.crimebusters.RegisterUserActivity;
import com.crime.crimebusters.login.Login;

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
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Login login = new Login();
		login.deleteUser("test.user99");
	}
	
	public void testCreateUser() { 
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click());

		onView(withId(R.id.sign_in_button)).check(matches(withText("Log in")));
	}
	
	public void testCreateUserWithEmptyUserName() {
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithEmptyPassword() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithEmptyFirstName() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithEmptyLastName() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithEmptyEmail() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithInvalidEmail() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test123"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("chris.ababan@gmail.com"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
	
	public void testCreateUserWithLessThanSixCharPassword() {
		onView(withId(R.id.createUser_userName)).perform(typeText("test.user99"));
		onView(withId(R.id.createUser_password)).perform(typeText("test1"));
		onView(withId(R.id.createUser_firstName)).perform(typeText("John"));
		onView(withId(R.id.createUser_lastName)).perform(typeText("Doe"));
		onView(withId(R.id.createUser_email)).perform(typeText("ababan2@illinois.edu"));
		
		onView(withId(R.id.createUser_button)).perform(click())
			.check(matches(withText("Create User")));
	}
}
