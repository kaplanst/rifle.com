import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Victoria extends BaseTest {

    public static void scroll(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollClick(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        scroll(driver, element);
        element.click();
    }

    @Test
    public void openRifle4WheelOffRoadPage() {
        driver.get("https://rifle.com/");
        scrollClick(driver, By.xpath("//li/a[normalize-space(text())='4 Wheel Off Road']"));
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Rifle 4 Wheel Off Road");
    }
}