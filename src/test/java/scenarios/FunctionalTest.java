package scenarios;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Stack;
import java.util.concurrent.TimeUnit;


public class FunctionalTest {
    static WebDriver driver;
    public static Stack<String> historyCalcStack;


    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        historyCalcStack = new Stack<>();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        driver.close();
    }
}