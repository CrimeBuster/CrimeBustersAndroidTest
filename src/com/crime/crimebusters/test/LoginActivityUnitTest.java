package com.crime.crimebusters.test;

import com.crime.crimebusters.LoginActivity;
import com.crime.crimebusters.R;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivityUnitTest extends ActivityUnitTestCase<LoginActivity> {

	private LoginActivity activity;
	private int loginButtonId;
	private int emailId;
	private int passwordId;
	
	public LoginActivityUnitTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), LoginActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}
	
	public void testLayout() {		
		emailId = R.id.email;
		assertNotNull(activity.findViewById(emailId));
		
		passwordId = R.id.password;
		assertNotNull(activity.findViewById(passwordId));
		
		loginButtonId = R.id.sign_in_button;
		assertNotNull(activity.findViewById(loginButtonId));
	}

	public void testIntentTriggerViaOnClick() throws InterruptedException {
		emailId = R.id.email;
		EditText email = (EditText)activity.findViewById(emailId);
		assertNotNull("Email is null", email);
		email.setText("crime.buster");
		
		passwordId = R.id.password;
		EditText password = (EditText)activity.findViewById(passwordId);
		assertNotNull("Password is null", password);
		password.setText("test123");
		
		loginButtonId = R.id.sign_in_button;
		Button loginButton = (Button)activity.findViewById(loginButtonId);
		assertNotNull("Login button is null", loginButton);
		loginButton.performClick();
		
		//Thread.sleep(4000);
		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", triggeredIntent);
	}
}
