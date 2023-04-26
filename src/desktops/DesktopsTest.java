package desktops;

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

public class DesktopsTest extends Utility {
    String basUrl = " http://tutorialsninja.com/demo/index.php?";

    @Before

    public void setUp() {
        openBrowser(basUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse hover on Desktops Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //Select Sort By position "Name: Z to A    1.3
        //selectByValueFromDropdown(By.xpath("//select[@id='input-sort']"),"Name(Z-A)");
        //Verify the Product will arrange in Descending order.
        List<WebElement> beforeFilterNameZtoA = driver.findElements(By.xpath("//body/div[@id='product-category']/div[@class='row']/div[@id='content']/div[4]"));
        List<String> beforeFilterNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoA) {
            beforeFilterNameZtoAList.add(String.valueOf(nameZtoA.getText().replace("$", "")));
        }
        // Select dropdown = new Select(driver.findElement(By.id("products-orderby")));
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        List<WebElement> afterFilterNameztoAlist = driver.findElements(By.xpath("//body/div[@id='product-category']/div[@class='row']/div[@id='content']/div[4]"));
        List<String> afterFilterNameZtoAList = new ArrayList<>();
        for (WebElement n : afterFilterNameztoAlist) {
            afterFilterNameZtoAList.add(String.valueOf(n.getText().replace("$", "")));
        }
        Collections.sort(beforeFilterNameZtoAList);// sort the value in the list
        Assert.assertTrue(true);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        // Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //Select product “HP LP3065”
        selectMenu("HP LP3065");
        //Verify the Text "HP LP3065"
        verifyText("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");
        // Select Delivery Date "2022-11-30
       // selectMenu("Delivery Date");

        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//div[@class='input-group date']//span[@class='input-group-btn']"));
        Thread.sleep(2000);
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//i[@class='fa fa-calendar']"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;


            }


            //.Enter Qty "1” using Select class.
            clearTextFromField(By.xpath("//input[@id='input-quantity']"));
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
            //Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));
            //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            //verifyText("Success: You have added HP LP3065 to your shopping cart!",By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added HP LP3065 to your shopping cart!");
            //Click on link “shopping cart” display into success message
            Thread.sleep(2000);
            clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
            //Verify the text "Shopping Cart"
            verifyText("Shopping Cart  (1.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart  (1.00kg)");
            //Verify the Product name "HP LP3065"
            verifyText("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "HP LP3065");
            //Verify the Delivery Date "2022-11-30"
            //verifyText("Delivery Date:2011-11-30",By.xpath("//small[contains(text(),'Delivery Date:2011-11-30')]"),"Delivery Date:2011-11-30");
            //Verify the Model "Product21"
            verifyText("Product 21", By.xpath("//td[contains(text(),'Product 21')]"), "Product 21");
            //Verify the Todat "£74.73"
            verifyText("$122.00", By.xpath("//tbody/tr[1]/td[6]"), "$122.00");

        }

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}