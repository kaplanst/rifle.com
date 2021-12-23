import Utils.BaseTest;
import Utils.UtilsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rifle4WheelOffRoadPageTest extends BaseTest {
    UtilsMethod utils;

    @Test
    public void openRifle4WheelOffRoadPage() {
        utils = new UtilsMethod(driver);
        driver.get("https://rifle.com/");
        utils.scrollClick(driver, By.xpath("//li/a[normalize-space(text())='4 Wheel Off Road']"));
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Rifle 4 Wheel Off Road");
    }
}