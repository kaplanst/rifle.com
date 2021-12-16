package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    MainPage mainPage;
    LoginPage loginPage;

    WebDriver driver;

    By username = By.id("ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_UserName");
    By password = By.id("ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password");
    By signInButton = By.id("ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton");
    By newUserField = By.id("ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_UserName");
    By newPasswordField = By.id("ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_Password");
    By confirmNewPasswordField = By.id("ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_ConfirmPassword");
    By registerButton = By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_RegisterButton']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage fillUsername (String strUserName){
        driver.findElement(username).sendKeys(strUserName);
        return this;
    }
    public LoginPage fillPassword (String strPassword){
        driver.findElement(password).sendKeys(strPassword);
        return this;
    }
    public LoginPage clickSigninButton (){
        driver.findElement(signInButton).click();
        return this;
    }
    public LoginPage fillNewUsername (String newName){
        driver.findElement(newUserField).sendKeys(newName);
        return this;
    }
    public LoginPage fillNewUserPassword (String newPassword){
        driver.findElement(newPasswordField).sendKeys(newPassword);
        return this;
    }
    public LoginPage confirmNewUserPassword (String newPassword){
        driver.findElement(confirmNewPasswordField).sendKeys(newPassword);
        return this;
    }
    public LoginPage clickRegisterButton (){
        driver.findElement(registerButton).click();
        return this;
    }


}
