package Tests;

import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tim extends BaseTest {

    @Test
    void fairingsClickTest(){  // Test case #TC-MP-001
        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_webpagePage']/div/div[1]/div[1]/a/img")).click();
        Assert.assertEquals(driver.getTitle(), "Fairings");
    }

    @Test
    void fairingsTitleTest(){  // Test case #TC-MP-002
        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_webpagePage']/div/div[1]/div[1]/a/img")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Fairings");
    }

    @Test
    void fairingsSortTest(){  // Test case #TC-MP-003
        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_webpagePage']/div/div[1]/div[1]/a/img")).click();
        driver.findElement(By.xpath("//*[@class='form-control-inline']")).click();
        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_SortResults']/option[3]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_CatalogNodeList_ctl00_CategoryItem_CategoryName']")).getText(), "Rifle Cruise Tour Fairing");
    }

    @Test
    void rifleCruiseTest(){  // Test case #TC-MP-004
        driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_webpagePage']/div/div[1]/div[1]/a/img")).click();
        driver.findElement(By.xpath("(//*[text()='Rifle Cruise Tour Fairing'])[4]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*/h1")).getText(), "Rifle Cruise Tour Fairing");
    }
}