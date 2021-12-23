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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public static final String LOGIN = "georgians_forever@gmail.com";
    public static final String WRONG_LOGIN = "georgians_forever@gmail";
    public static final String PASSWORD = "Qwerty1";
    private static final String LOGIN_PROP = "default.username";
    private static final String PAS_PROP = "default.password";

    public static Properties properties;

    public static String getUserName() {
        properties = new Properties();
        return properties.getProperty(LOGIN_PROP);
    }

    public static String getUserPassword() {
        properties = new Properties();
        return properties.getProperty(PAS_PROP);
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws FileNotFoundException {
        Date dateNow = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH_mm_ss");
        SimpleDateFormat formatDateTime = new SimpleDateFormat("MMMMM d - HH:mm:ss");

        String fileName = result.getName() + "-" + formatTime.format(dateNow) + ".png";
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("C:/TestsLog/" + fileName));
                System.out.println("Screenshot file '"  + fileName + "' has been created ");
            } catch (Exception e){
                System.out.println("Impossible to take screenshot");
            }
        }

        float runTime = (float)( result.getEndMillis() - result.getStartMillis() )/1000;
        PrintWriter consoleOutput = new PrintWriter(new FileOutputStream("C:/TestsLog/log.txt"),true);
        consoleOutput.println(formatDateTime.format(dateNow) + " | Finished correctly: "
                + result.isSuccess() + " | Run time: " + runTime + " sec\t| " + result.getName());
        consoleOutput.flush();
        consoleOutput.close();

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
