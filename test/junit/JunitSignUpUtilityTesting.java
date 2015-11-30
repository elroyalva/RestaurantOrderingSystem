package junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;  
import form.SignUpForm;

import static org.junit.Assert.*;
import utility.SignUpUtility;

@RunWith(MockitoJUnitRunner.class) 
public class JunitSignUpUtilityTesting {
	
	SignUpUtility signup;
	
	@Mock
	SignUpForm sForm;
	
	@Before
	public void setUp()
	{
		 signup = new SignUpUtility();
	}
	
	@Test
	public void TestinsertData()
	{
		int rval = signup.insertData(sForm);
		assertEquals(rval,1);
	}

	
	
}
