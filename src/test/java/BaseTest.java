import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser (String baseURL){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);
    }

    @AfterMethod
    public void tearDownBrowser (){
        driver.quit();

    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    @DataProvider(name = "IncorrectLoginProviders")
    public Object[][] getCredentials() {

        return new Object[][]{
                {"Invalid@class.com", "InvalidPass" },
                {"d@class", "" },
                {"", "" },

        };
    }
}
