package com.illinoiscrimebusters.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

import com.crime.crimebusters.R;
import com.illinoiscrimebusters.crimebusters.RegisterUserActivity;
import com.illinoiscrimebusters.login.Login;

public class RegisterUserActivityUnitTest extends
		ActivityUnitTestCase<RegisterUserActivity> {
	private RegisterUserActivity _activity;
	private int _userNameId;
	private int _passwordId;
	private int _firstNameId;
	private int _lastNameId;
	private int _emailId;
	private int _createUserButtonId;

	public RegisterUserActivityUnitTest() {
		super(RegisterUserActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getContext(),
				RegisterUserActivity.class);
		startActivity(intent, null, null);
		_activity = getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		Login login = new Login();
		login.deleteUser("test.user99");
	}
	
	public void testLayout() {
		_userNameId = R.id.createUser_userName;
		assertNotNull("Cannot find username field.",
				_activity.findViewById(_userNameId));

		_passwordId = R.id.createUser_password;
		assertNotNull("Cannot find password field.",
				_activity.findViewById(_passwordId));

		_firstNameId = R.id.createUser_firstName;
		assertNotNull("Cannot find first name field.",
				_activity.findViewById(_firstNameId));

		_lastNameId = R.id.createUser_lastName;
		assertNotNull("Cannot find last name field.",
				_activity.findViewById(_lastNameId));

		_emailId = R.id.createUser_email;
		assertNotNull("Cannot find email field.",
				_activity.findViewById(_emailId));

		_createUserButtonId = R.id.createUser_button;
		assertNotNull("Cannot find create user button.",
				_activity.findViewById(_createUserButtonId));
	}

	public void testIntentTriggerViaOnClick() {
		_userNameId = R.id.createUser_userName;
		EditText userName = (EditText)_activity.findViewById(_userNameId);
		assertNotNull("Username is null", userName);
		userName.setText("test.user99");
		
		_passwordId = R.id.createUser_password;
		EditText password = (EditText)_activity.findViewById(_passwordId);
		assertNotNull("Password is null.", password);
		password.setText("test123");
		
		_firstNameId = R.id.createUser_firstName;
		EditText firstName = (EditText)_activity.findViewById(_firstNameId);
		assertNotNull("FirstName is null.", firstName);
		firstName.setText("John");
		
		_lastNameId = R.id.createUser_lastName;
		EditText lastName = (EditText)_activity.findViewById(_lastNameId);
		assertNotNull("LastName is null.", lastName);
		lastName.setText("Doe");
		
		_emailId = R.id.createUser_email;
		EditText email = (EditText)_activity.findViewById(_emailId);
		assertNotNull("Email is null.", email);
		email.setText("ababan2@illinois.edu");
		
		_createUserButtonId = R.id.createUser_button;
		Button createUserButton = (Button)_activity.findViewById(_createUserButtonId);
		assertNotNull("Create user button is null.", createUserButton);
		createUserButton.performClick();
		
		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null.", triggeredIntent);
	}

}
