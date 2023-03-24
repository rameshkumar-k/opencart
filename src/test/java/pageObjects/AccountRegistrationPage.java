package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email_id;
	
	@FindBy(name="telephone")
	WebElement telephone;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirm")
	WebElement confirm_password;
	
	@FindBy(name="agree")
	WebElement agree_condition_check_box;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement success_msg;
	
	
	public void setfirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void setlastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		email_id.sendKeys(email);
	}
	
	public void setTelephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setconfirmPassword(String cpass)
	{
		confirm_password.sendKeys(cpass);
	}
	
	public void clickAgree()
	{
		agree_condition_check_box.click();
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public String getConfirmationMessage()
	{
		return success_msg.getText();
	}
}
