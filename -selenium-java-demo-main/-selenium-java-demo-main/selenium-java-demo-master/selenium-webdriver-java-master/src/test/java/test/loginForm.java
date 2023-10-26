package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Delayed;

@Test
public class loginForm {
    public static void testLoginForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page - Login Form
            //driver.get("https://the-internet.herokuapp.com/login");
            driver.get("https://meetinglecturers.giakhang3005.com/");
            //3. Find username web element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement usernameElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#userId"))));//#username
            //WebElement usernameElem = driver.findElement(By.xpath("//input[@id='username']"));
            //4. Find password web element
            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));//#password
            //5. Find login btn web element
            WebElement loginBtnElem = driver.findElement(By.cssSelector("button[type='submit']"));//submit
            //6. Input username, input password, click on Login btn
            usernameElem.sendKeys("admin");
            passwordElem.sendKeys("123");//12345678
            loginBtnElem.click();
            //7. Quit browser session
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
