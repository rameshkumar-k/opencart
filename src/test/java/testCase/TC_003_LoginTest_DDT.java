package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginTest_DDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String expected_result)
	{
		logger.info("Starting TC_003_loginTest_DDT");
		
		try
		{
		
		HomePage hp= new HomePage(driver);
		hp.click_MyAccount();
		logger.info("Clicked on My Account");
		hp.click_Login();
		logger.info("Clicked on Login");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Entered Email...");
		lp.setPassword(password);
		logger.info("Entered Password...");
		lp.clickLogin();
		logger.info("Clicked Login...");
		
		MyAccount mc=new MyAccount(driver);
		boolean targetPage=mc.isMyAccountDisplayed();
		
		if(expected_result.equals("valid")) {
			
			if(targetPage==true)
			{
				mc.clickLogout();
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.fail();
			}
		}
			
		if(expected_result.equals("Invalid")) {
				
			if(targetPage==true)
			{
				mc.clickLogout();
				Assert.assertTrue(false);
			}
				
				
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_003_loginTest_DDT");

		}
	}

