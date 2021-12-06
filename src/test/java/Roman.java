import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Roman {

    @Test
    void shoppingCartAddRemoveTest() throws InterruptedException { //TEST CASE TEST RAIL: C12
        WebDriver romabot;
        WebDriverManager.chromedriver().setup();
        romabot = new ChromeDriver();
        romabot.get("https://rifle.com/4-Wheel-Off-Road/Suzuki-Samurai/Suzuki-Samurai-Under-Seat-Storage-Tray.aspx");
        romabot.manage().window().maximize();

        romabot.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        romabot.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageFooter_StoreFooterRifle_F_BasketLink']")).click();

        Assert.assertEquals(romabot.findElement(By.xpath("//*[@class='fieldHeader']")).getText(), "Subtotal:");

        romabot.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ClearBasketButton']")).click();

        romabot.switchTo().alert().accept();

        Thread.sleep(2000);

        Assert.assertEquals(romabot.findElement(By.xpath("//*[@class='message']")).getText(), "Your cart is empty.");

    }

}
