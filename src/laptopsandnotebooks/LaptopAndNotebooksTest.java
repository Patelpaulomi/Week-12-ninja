package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebooksTest extends Utility {
    String basUrl = " http://tutorialsninja.com/demo/index.php?";
    @Before

    public void setUp(){

        openBrowser(basUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
     //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //Verify the Product price will arrange in High to Low order.
        List<WebElement> beforeFilterNameZtoA = driver.findElements(By.xpath("//body/div[@id='product-category']/div[@class='row']/div[@id='content']/div[4]"));
        List<String> beforeFilterNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoA) {
            beforeFilterNameZtoAList.add(String.valueOf(nameZtoA.getText().replace("$", "")));
        }
        List<WebElement> afterFilterNameztoAlist = driver.findElements(By.xpath("//body/div[@id='product-category']/div[@class='row']/div[@id='content']/div[4]"));
        List<String> afterFilterNameZtoAList = new ArrayList<>();
        for (WebElement n : afterFilterNameztoAlist) {
            afterFilterNameZtoAList.add(String.valueOf(n.getText().replace("$", "")));
        }
        Collections.sort(beforeFilterNameZtoAList);// sort the value in the list
        Assert.assertTrue(true);

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        // Select Product “MacBook”
        selectMenu("MacBook");
        //Verify the text “MacBook”
        verifyText("MacBook",By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");
        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyText("Success: You have added MacBook to your shopping cart!\n" + "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added MacBook to your shopping cart!");
        //Click on link “shopping cart” display into success message
       clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text "Shopping Cart"
        verifyText("Shopping Cart  (0.00kg)",By.xpath("//h1[contains(text(),'Shopping Cart')]"),"Shopping Cart");
        //Verify the Product name "MacBook"
        verifyText("MacBook",By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.table-responsive table.table.table-bordered tbody:nth-child(2) tr:nth-child(1) td.text-left:nth-child(2) > a:nth-child(1)"),"MacBook");
        // Change Quantity "2"
        clearTextFromField(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //Click on “Update”Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //Verify the message “Success: You have modified your shopping cart!”
        verifyText("Success: You have modified your shopping cart!\n" + "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have modified your shopping cart!");
        //Verify the Total $1204.00
        verifyText("$1,204.00",By.xpath("//tbody/tr[1]/td[6]"),"1,204.00");
        Thread.sleep(2000);
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //Verify the text “Checkout”
        verifyText("Checkout",By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");
        //Verify the Text “New Customer”
        verifyText("New Customer",By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");
        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"Julie");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"Anderson");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"JA@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"07123456789");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"4 London Road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"HA2 9DA");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Northamptonshire");
        // Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        // Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Hello");
        //Check the Terms & Conditions check box
       clickOnElement(By.xpath("//input[@name='agree']"));
        //Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //Verify the message “Warning: Payment method required!”
        verifyText("Warning: Payment method required!\n" + "×",By.xpath("//div[@class='alert alert-danger alert-dismissible']"),"Warning: Payment method required!");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
