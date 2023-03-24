package testCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.click_MyAccount();
		logger.info("Clicked on My Account link");
		hp.click_Register();
		logger.info("Clicked on Register link");
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		arp.setfirstName("Ramesh");
		arp.setlastName("Kumar");
		arp.setEmail(randomString().toLowerCase()+"@gmail.com");
		arp.setTelephone(randomNumber());
		arp.setPassword("test@333");
		arp.setconfirmPassword("test@333");
		arp.clickAgree();
		arp.clickSubmit();
		logger.info("Clicked on continue");
		String confmsg="Your Account Has Been Created!";
		logger.info("Validating expected message");
		Assert.assertEquals(arp.getConfirmationMessage(), confmsg,"Title is not matching with expected");
		}
		
		catch(Exception e)
		{
			logger.error("Title is not matching with expected");
			Assert.fail();
		}
		
		logger.info("**** Finished TC_001_AccountRegistrationTest ****");
	}
	


}
