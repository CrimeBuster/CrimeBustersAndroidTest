package com.illinoiscrimebusters.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.clearText;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

import com.crime.crimebusters.R;
import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.illinoiscrimebusters.crimebusters.MainFormActivity;
import com.illinoiscrimebusters.crimebusters.ReportIncidentActivity;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

public class ReportIncidentActivityUiTest
	extends ActivityInstrumentationTestCase2<ReportIncidentActivity> {
	private Activity _activity;
	
	public ReportIncidentActivityUiTest() {
		super(ReportIncidentActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		_activity = getActivity();
	}
	
	@Override
	public void tearDown() throws Exception {
		Espresso.pressBack();
		super.tearDown();
	}
	
	public void testIncidentReport() {
		goToMainForm();
		onView(withId(R.id.report_ongoing_incident)).perform(click());
		
		onView(withId(R.id.location)).perform(clearText())
			.perform(typeText("Test location"));		;	
		onView(withId(R.id.message)).perform(clearText())
			.perform(typeText("Test Message"));
		
		onView(withId(R.id.submitReport)).perform(click());
		onView(withId(R.id.textView2)).check(matches(withText("Thank you for your report. Your submission has been successfully received")));
	}
	
	private void goToMainForm() {
		Intent intent = new Intent(getInstrumentation().getTargetContext(), 
				MainFormActivity.class);
		intent.putExtra("userName", "crime.buster");
		_activity.startActivity(intent);
	}
}
