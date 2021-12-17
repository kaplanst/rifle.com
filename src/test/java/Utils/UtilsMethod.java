package Utils;

import model.CartPage;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
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

    public CartPage clearCart() {
        try {
            driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ClearBasketButton']")).click();
            driver.switchTo().alert().accept();
            System.out.println("Cart contained some items");

        } catch (Exception e){
            System.out.println("Cart was empty");
        }
        return new CartPage(driver);
    }

}
