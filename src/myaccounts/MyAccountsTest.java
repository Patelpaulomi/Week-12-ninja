package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php?";

    @Before

    public void setup() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        // Verify the text “Register Account”.
        verifyText("Register Account", By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
        // Verify the text “Returning Customer”.
        verifyText("Returning Customer", By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException{
        Thread.sleep(3000);
        // Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        // Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Sun");
        // Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Flower");
        // Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "SF1@gmail.com");
        // Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07123456789");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Flower1234");
        // Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Flower1234");
        // Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        // Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // Verify the message “Your Account Has Been Created!”
        verifyText("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        // Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        // Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
        //Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "SF1@gmail.com");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Flower1234");
        // Click on Login button
        clickOnElement(By.xpath("//input[@type='submit']"));
        // Verify text “My Account”
        verifyText("My Account", By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        // Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}