package com.illinoiscrimebusters.test;

import com.crime.crimebusters.R;
import com.illinoiscrimebusters.crimebusters.LoginActivity;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

public class LoginActivityUnitTest extends ActivityUnitTestCase<LoginActivity> {

	private LoginActivity _activity;
	private int _loginButtonId;
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
	
	public void testLayout() {		
		_emailId = R.id.email;
		assertNotNull(_activity.findViewById(_emailId));
		
		_passwordId = R.id.password;
		assertNotNull(_activity.findViewById(_passwordId));
		
		_loginButtonId = R.id.sign_in_button;
		assertNotNull(_activity.findViewById(_loginButtonId));
	}
}
