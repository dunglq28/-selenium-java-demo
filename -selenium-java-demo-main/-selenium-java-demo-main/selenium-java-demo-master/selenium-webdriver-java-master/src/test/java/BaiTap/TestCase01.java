package test;

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

/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/
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
    }

    public static void main(String[] args) {
        TestCase01();
    }
}
