package Utils;

import model.CartPage;
import model.LoginPage;
import model.Menus.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class UtilsMethod extends BaseTest{
    Header header;
    LoginPage loginPage;
    WebDriver driver;

    public UtilsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void loginDefault() {
        header = new Header(driver);
        loginPage = header.clickLoginButton()
                .fillUsername(getUserName())
                .fillPassword(getUserPassword())
                .clickSigninButton();
    }

    public void scroll(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollClick(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        scroll(driver, element);
        element.click();
    }

    public CartPage clearCart() {
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ClearBasketButton']")).click();
            driver.switchTo().alert().accept();
            System.out.println("Cart contained some items");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Cart was empty");
        }
        return new CartPage(driver);
    }

}
