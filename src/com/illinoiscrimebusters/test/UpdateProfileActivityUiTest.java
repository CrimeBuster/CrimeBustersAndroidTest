package com.illinoiscrimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.clearText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

import com.crime.crimebusters.R;
import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.illinoiscrimebusters.crimebusters.MainFormActivity;
import com.illinoiscrimebusters.crimebusters.UpdateProfileActivity;
import com.illinoiscrimebusters.user.User;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

public class UpdateProfileActivityUiTest extends ActivityInstrumentationTestCase2<UpdateProfileActivity> {
	private UpdateProfileActivity _activity;
	
	public UpdateProfileActivityUiTest() {
		super(UpdateProfileActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), 
				UpdateProfileActivity.class);
		intent.putExtra("userName", "crime.buster");
		setActivityIntent(intent);
		_activity = getActivity();
	}
	
	@Override
	protected void tearDown() throws Exception {
	    super.tearDown();
	    User user = new User("crime.buster", "John", "Doe", "M", 
	    		"+17171234567", "Urbana, Champaign", "12345");
	    _activity = getActivity();
	    user.updateProfile(_activity);
	}
	
	public void testUpdateFirstName() {
		onView(withId(R.id.updateProfile_firstName)).perform(typeText(" Update"));		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_firstName)).check(matches(withText("John Update")));
	}
	
	public void testUpdateLastName() {
		onView(withId(R.id.updateProfile_lastName)).perform(typeText(" Update"));		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_lastName)).check(matches(withText("Doe Update")));
	}
	
	public void testUpdatePhoneNumber() {
		onView(withId(R.id.updateProfile_phoneNumber)).perform(clearText()).perform(typeText("+639171234567"));		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_phoneNumber)).check(matches(withText("+639171234567")));
	}
	
	public void testUpdateAddress() {
		onView(withId(R.id.updateProfile_address)).perform(clearText()).perform(typeText("New York, NY"));		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_address)).check(matches(withText("New York, NY")));
	}
	
	public void testUpdateZipCode() {
		onView(withId(R.id.updateProfile_zipCode)).perform(clearText()).perform(typeText("new zip code"));		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_zipCode)).check(matches(withText("new zip code")));
	}
	
	public void testUpdateEmptyFirstName() {
		onView(withId(R.id.updateProfile_firstName)).perform(clearText());		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_firstName)).check(matches(withText("John")));
	}
	
	public void testUpdateEmptyLastName() {
		onView(withId(R.id.updateProfile_lastName)).perform(clearText());		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_lastName)).check(matches(withText("Doe")));
	}
	
	public void testUpdateEmptyPhoneNumber() {
		onView(withId(R.id.updateProfile_phoneNumber)).perform(clearText());		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_phoneNumber)).check(matches(withText("")));
	}
	
	public void testUpdateEmptyAddress() {
		onView(withId(R.id.updateProfile_address)).perform(clearText());		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();
		
		onView(withId(R.id.updateProfile_address)).check(matches(withText("")));
	}
	
	public void testUpdateEmptyZipCode() {
		onView(withId(R.id.updateProfile_zipCode)).perform(clearText());		
		onView(withId(R.id.updateProfile_button)).perform(click());
		
		goToMainForm();
		Espresso.pressBack();

		onView(withId(R.id.updateProfile_zipCode)).check(matches(withText("")));
	}

	private void goToMainForm() {
		Intent intent = new Intent(getInstrumentation().getTargetContext(), 
				MainFormActivity.class);
		intent.putExtra("userName", "crime.buster");
		_activity.startActivity(intent);
	}
}
