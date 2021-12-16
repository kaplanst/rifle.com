package Utils;

import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.WebDriver;

public class UtilsMethod {
    MainPage mainPage;
    LoginPage loginPage;
    WebDriver driver;

    public UtilsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String login, String pass) {
        mainPage = new MainPage(driver);
        loginPage = mainPage.clickLoginButton()
                 .fillUsername(login)
                 .fillPassword(pass)
                 .clickSigninButton();
    }

}
