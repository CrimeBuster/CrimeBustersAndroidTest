package com.illinoiscrimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

import com.crime.crimebusters.R;
import com.illinoiscrimebusters.crimebusters.UpdateProfileActivity;

import android.test.ActivityInstrumentationTestCase2;

public class UpdateProfileActivityUiTest extends ActivityInstrumentationTestCase2<UpdateProfileActivity> {
	public UpdateProfileActivityUiTest() {
		super(UpdateProfileActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		getActivity();
		
	}
	
	public void testUpdateUser() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText("John Update"));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText("Doe Update"));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText("+1234567"));
		onView(withId(R.id.updateProfile_address)).perform(typeText("address updated"));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText("zip code updated"));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
	
	public void testUpdateUserEmptyFirstName() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText(""));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText("Doe Update"));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText("+1234567"));
		onView(withId(R.id.updateProfile_address)).perform(typeText("address updated"));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText("zip code updated"));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
	
	public void testUpdateUserEmptyLastName() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText("John Update"));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText(""));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText("+1234567"));
		onView(withId(R.id.updateProfile_address)).perform(typeText("address updated"));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText("zip code updated"));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
	
	public void testUpdateUserEmptyPhoneNumber() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText("John Update"));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText("Doe Update"));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText(""));
		onView(withId(R.id.updateProfile_address)).perform(typeText("address updated"));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText("zip code updated"));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
	
	public void testUpdateUserEmptyAddress() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText("John Update"));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText("Doe Update"));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText("+1234567"));
		onView(withId(R.id.updateProfile_address)).perform(typeText(""));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText("zip code updated"));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
	
	public void testUpdateUserEmptyZipCode() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText("John Update"));
		onView(withId(R.id.updateProfile_lastName)).perform(typeText("Doe Update"));
		onView(withId(R.id.updateProfile_phoneNumber)).perform(typeText("+1234567"));
		onView(withId(R.id.updateProfile_address)).perform(typeText("address updated"));
		onView(withId(R.id.updateProfile_zipCode)).perform(typeText(""));
		
		
		onView(withId(R.id.updateProfile_button)).perform(click())
			.check(matches(withText(containsString("Profile"))));
	}
}
