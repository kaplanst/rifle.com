package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    public void byeBye(){
       driver.quit();
    }
}
