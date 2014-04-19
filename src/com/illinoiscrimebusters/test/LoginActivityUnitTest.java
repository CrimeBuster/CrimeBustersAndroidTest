package com.illinoiscrimebusters.test;

import com.crime.crimebusters.R;
import com.illinoiscrimebusters.crimebusters.LoginActivity;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivityUnitTest extends ActivityUnitTestCase<LoginActivity> {

	private LoginActivity _activity;
	private int _loginButtonId;
	private int _createUserButtonId;
	private int _emailId;
	private int _passwordId;
	
	public LoginActivityUnitTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), LoginActivity.class);
		startActivity(intent, null, null);
		_activity = getActivity();
	}
	
	protected void tearDown() throws Exception {
	    super.tearDown();
	}
	
	public void testLayout() {		
		_emailId = R.id.email;
		assertNotNull(_activity.findViewById(_emailId));
		
		_passwordId = R.id.password;
		assertNotNull(_activity.findViewById(_passwordId));
		
		_loginButtonId = R.id.sign_in_button;
		assertNotNull(_activity.findViewById(_loginButtonId));
		
		_createUserButtonId = R.id.create_user_button;
		assertNotNull(_activity.findViewById(_createUserButtonId));
	}
	
	public void testIfRegisterUserIntentTriggered() throws InterruptedException {
		_emailId = R.id.email;
		EditText email = (EditText)_activity.findViewById(_emailId);
		assertNotNull("Email is null", email);
		email.setText("crime.buster");

		_passwordId = R.id.password;
		EditText password = (EditText)_activity.findViewById(_passwordId);
		assertNotNull("Password is null", password);
		password.setText("test123");

		_createUserButtonId = R.id.create_user_button;
		Button createUserButton = (Button)_activity.findViewById(_createUserButtonId);
		assertNotNull("Cannot find create user button", createUserButton);
		createUserButton.performClick();

		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", triggeredIntent);
	}	
}
