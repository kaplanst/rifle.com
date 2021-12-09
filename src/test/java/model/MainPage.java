package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    WebDriver driver;

//    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")
//    WebElement loginButton;
//
//    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink']")
//    WebElement accountButton;
//
//    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink']")
//    WebElement wishListButton;
//
//    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink']")
//    WebElement cartButton;

    By loginButton = By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']");

    By accountButton = By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink']");

    By wishListButton = By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink']");

    By cartButton = By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        //super(driver);
    }

    public void clickLoginButton(){
        //driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")).click();
        driver.findElement(loginButton).click();
        //loginButton.click();
        //new LoginPage(driver);
    }

    public void clickAccountButton(){
        driver.findElement(accountButton).click();
    }

    public void clickWishlistButton(){
        driver.findElement(wishListButton).click();
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }

}
