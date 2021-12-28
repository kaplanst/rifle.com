package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
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
    public static final String LOGIN_PROP = "default.username";
    public static final String PAS_PROP = "default.password";
    public static final String PROPERTY_PATH = System.getProperty("user.dir")
                                                + "\\src\\test\\resources\\local.properties";

    public static Properties properties;

    public String getUserName() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_PATH);
            properties = new Properties();
            properties.load(fis);

        } catch (Exception e) {
            System.out.println("There is no properties file");
        }
        return properties.getProperty(LOGIN_PROP);
    }

    public String getUserPassword() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_PATH);
            properties = new Properties();
            properties.load(fis);

        } catch (Exception e) {
            System.out.println("There is no properties file");
        }
        return properties.getProperty(PAS_PROP);
    }

    public String getBrowser() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_PATH);
            properties = new Properties();
            properties.load(fis);

        } catch (Exception e) {
            System.out.println("There is no properties file");
        }
        return properties.getProperty("browser");
    }

    @BeforeMethod
    public void setUp(){
        if (getBrowser().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (getBrowser().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (getBrowser().equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
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
        PrintWriter consoleOutput = new PrintWriter(new FileOutputStream(new File("C:/TestsLog/log.txt"),true));
        consoleOutput.println(formatDateTime.format(dateNow) + " | Finished correctly: "
                + result.isSuccess() + " | Run time: " + runTime + " sec\t| " + result.getName());
        consoleOutput.flush();
        consoleOutput.close();

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
