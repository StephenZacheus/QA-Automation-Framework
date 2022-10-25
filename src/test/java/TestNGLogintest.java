import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGLoginTest extends BaseTest {

    @Test (priority = 0)
    public void LoginValidEmailPasswordTest() {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }


    @Test
    public void LoginInvalidEmailPasswordTest() throws InterruptedException {
        openLoginUrl();
        enterEmail("invalid@gmail.com");
        enterPassword("InvalidPassword");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/");
    }

    public void openLoginUrl() {
        driver.get("https://bbb.testpro.io/");
    }


    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
        emailField.click();
        emailField.sendKeys("demo@class.com");
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type ='password"));
        passwordField.click();
        passwordField.sendKeys(password);
        }


        public void clickSubmit() {
    }

}







//        public void enterEmail(String email) {
//        WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
//        emailField.click();// click to element
//        emailField.sendKeys("demo@class.com")
//
//    }

//
//
//    @Test
//    public void LoginInvalidEmailValidPasswordTest(){
//        WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
//        emailField.click();// click to element
//        emailField.sendKeys("demo@class.com");//typing demo@class.com in email field
//
//        WebElement passwordField = driver.findElement(By.cssSelector("[type ='password"));
//        passwordField.click();// click to element
//        passwordField.sendKeys("te$t$tudent");
//
//        WebElement submitButton = driver.findElement(By.cssSelector("[type ='submit"));
//        submitButton.click();// click to element
//
//
//    }
//
//    WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
//            emailField.click();// click to element
//            emailField.sendKeys("demo@class.com");//typing demo@class.com in email field
//
//    WebElement passwordField = driver.findElement(By.cssSelector("[type ='password"));
//            passwordField.click();// click to element
//            passwordField.sendKeys("te$t$tudent");
//
//    WebElement submitButton = driver.findElement(By.cssSelector("[type ='submit"));
//            submitButton.click();// click to element



