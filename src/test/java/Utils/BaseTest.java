package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public static final String LOGIN = "georgians_forever@gmail.com";
    public static final String WRONG_LOGIN = "georgians_forever@gmail";
    public static final String PASSWORD = "Qwerty1";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = result.getName() + "-" + format.format(dateNow) + ".png";
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("C:/Screenshots/" + fileName));
                System.out.println("Screenshot file '"  + fileName + "' has been created ");
            } catch (Exception e){
                System.out.println("Impossible to take screenshot");

            }
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
