package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alex {

    @Test
    void copyrightElementTest() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
        Assert.assertEquals(driver.findElement(By.className("copyright1")).getText(), "Copyright © 1995-2018 RIFLE Fairings. All rights reserved.");
        driver.quit();
    }

    @Test
    void FooterCategoryTest() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
        driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageFooter_StoreFooterRifle_F_FourWheelLink")).click();
        driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageContent_ctl00_CatalogNodeList_ctl00_CategoryItem_CategoryName")).click();
        driver.findElement(By.xpath("//*['ctl00_ctl00_NestedMaster_PageContent_ctl00_CatalogNodeList_ctl00']"));
        driver.quit();
    }

}
