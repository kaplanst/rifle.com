import Utils.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Roman extends BaseTest {

    @Test
    void shoppingCartAddRemoveTest() throws InterruptedException { //TEST CASE TC-FT-008
        driver.get("https://rifle.com/4-Wheel-Off-Road/Suzuki-Samurai/Suzuki-Samurai-Under-Seat-Storage-Tray.aspx");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageFooter_StoreFooterRifle_F_BasketLink']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='fieldHeader']")).getText(), "Subtotal:");

        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ClearBasketButton']")).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='message']")).getText(), "Your cart is empty.");

        driver.quit();

    }

    void shoppingCartMultipleQuantityEditTest(){

        driver.get("https://rifle.com/4-Wheel-Off-Road/Suzuki-Samurai/Suzuki-Samurai-Under-Seat-Storage-Tray.aspx");


    }

}
