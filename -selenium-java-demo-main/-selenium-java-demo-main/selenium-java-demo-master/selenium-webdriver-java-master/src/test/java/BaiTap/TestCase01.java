package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Test
public class TestCase01 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "D:\\-selenium-java-demo-main\\-selenium-java-demo-main\\selenium-java-demo-master\\screenshot";
    public static void testCase01() throws InterruptedException, IOException {
        int src = 0;
        StringBuilder verificationError = new StringBuilder();
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("MOBILE")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> options = driver.findElements(By.tagName("option"));
        WebElement option2 = options.get(1);
        option2.click();
        Thread.sleep(2000);
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String autoAllocate = "screenshot2.png";
        FileHandler.copy(srcFile, new File(destFile + autoAllocate));
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        testCase01();
    }
}
