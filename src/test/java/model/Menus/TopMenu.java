package model.Menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TopMenu {
    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public By homeLink = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavHomeLink");
    public By searchByModelsLink = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavSearchModelLink");
    public By contactRifleLink = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavContactLink");
    public By productsDropDown = By.xpath("//*[@id='cssmenu']/ul/li[1]");
    public By infoDropDown = By.xpath("//*[@id='cssmenu']/ul/li[2]");
    public By aboutAsLink = By.xpath("//a[@href='/About-Us.aspx']");
    public By windshieldSelectionGuide = By.xpath("//*[@id='cssmenu']//*[contains(text(),'Windshield Selection Guide')]");
    public By orderInfo = By.xpath("//*[@id='cssmenu']//*[contains(text(),'Order Info')]");
    public By becomeDealer = By.xpath("//*[@id='cssmenu']//*[contains(text(),'Become a Dealer')]");
    public By inquireAboutCustomManufacturing = By.xpath("//*[@id='cssmenu']//*[contains(text(),'Inquire About Custom Manufacturing')]");
    public By justReleasedLink = By.xpath("//*[@id='cssmenu']//*[contains(text(),'Just Released')]");
    public By shortHomeLink = By.id("ctl00_ctl00_PageHeader_StoreHeader_BootNavHomeLink");
    public By contactUsLink = By.id("ctl00_ctl00_PageHeader_StoreHeader_BootNavContactLink");


    public void clickHomeLink(){driver.findElement(homeLink).click();}
    public void clickSearchByModelsLink(){driver.findElement(searchByModelsLink).click();}
    public void clickContactRifleLink(){driver.findElement(contactRifleLink).click();}
    public void clickAboutAsLink(){driver.findElement(aboutAsLink).click();}
    public void clickWindshieldSelectionGuide(){driver.findElement(windshieldSelectionGuide).click();}
    public void clickOrderInfo(){driver.findElement(orderInfo).click();}
    public void clickBecomeDealer(){driver.findElement(becomeDealer).click();}
    public void clickInquireAboutCustomManufacturing(){driver.findElement(inquireAboutCustomManufacturing).click();}

    public void clickItem(String item) {
        driver.findElement(By.xpath("//*[@id='cssmenu']//*[contains(text(),'" + item + "')]")).click();
    }

    public TopMenu checkProductsDropDown(String item){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By
                .xpath("//*[@id='cssmenu']//*[contains(text(),'" + item + "')]"))).build().perform();
        return this;
    }
    public TopMenu checkInfoDropDown(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(infoDropDown)).build().perform();
        return this;
    }
    public void topMenuShortTest() {
        Assert.assertTrue(driver.findElement(shortHomeLink).isDisplayed());
        System.out.println("Test is going well");
        Assert.assertTrue(driver.findElement(contactUsLink).isDisplayed());
    }

    public void topMenuFullTest() {
        Assert.assertTrue(driver.findElement(homeLink).isDisplayed());
        Assert.assertTrue(driver.findElement(searchByModelsLink).isDisplayed());
        Assert.assertTrue(driver.findElement(contactRifleLink).isDisplayed());
        Assert.assertTrue(driver.findElement(productsDropDown).isDisplayed());
        Assert.assertTrue(driver.findElement(aboutAsLink).isDisplayed());

        checkInfoDropDown();
        Assert.assertTrue(driver.findElement(windshieldSelectionGuide).isDisplayed());
        Assert.assertTrue(driver.findElement(orderInfo).isDisplayed());
        Assert.assertTrue(driver.findElement(becomeDealer).isDisplayed());
        Assert.assertTrue(driver.findElement(inquireAboutCustomManufacturing).isDisplayed());

        checkProductsDropDown("  Products");
        Assert.assertTrue(driver.findElement(justReleasedLink).isDisplayed());
    }
}
