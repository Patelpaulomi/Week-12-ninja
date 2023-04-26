package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String basUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(basUrl);
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()throws InterruptedException {
        Thread.sleep(2000);
        // Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        //Verify the text ‘Desktops’
        verifyText("Desktops",By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
    }
    @Test
    public void  verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()throws InterruptedException {
        Thread.sleep(2000);
        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks
        selectMenu("Show AllLaptops & Notebooks");
        // Verify the text ‘Laptops & Notebooks
        verifyText("Laptops & Notebooks", By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"), "Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully()throws InterruptedException{
        Thread.sleep(2000);
        //Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));
        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //Verify the text ‘Components’
        verifyText("Components",By.xpath("//h2[contains(text(),'Components')]"),"Components");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
