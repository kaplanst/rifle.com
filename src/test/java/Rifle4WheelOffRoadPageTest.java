import Utils.BaseTest;
import Utils.UtilsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Rifle4WheelOffRoadPageTest extends BaseTest {
    UtilsMethod utils = new UtilsMethod(driver);

    @Test
    public void testOpenRifle4WheelOffRoadPage() {
        utils.scrollClick(driver, By.xpath("//li/a[normalize-space(text())='4 Wheel Off Road']"));
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Rifle 4 Wheel Off Road");
    }

    @Test
    public void testDropdownMenuCountElements(){
        utils.scrollClick(driver, By.xpath("//li/a[normalize-space(text())='4 Wheel Off Road']"));
        driver.findElement(By.xpath("//select[@class='form-control-inline']")).click();

        Select objSelect = new Select((WebElement) driver.findElement(By.xpath("//select[@class='form-control-inline']")));
        List<WebElement> elementCount = objSelect.getOptions();
        System.out.println(elementCount.size());

        Assert.assertEquals(elementCount.size(), 8);
    }
}