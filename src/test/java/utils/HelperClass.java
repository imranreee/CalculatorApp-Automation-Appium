package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public abstract class HelperClass {
    protected static WebDriver driver;

    public HelperClass(WebDriver driver) {
        this.driver = driver;
    }

    // waiting for element until visible for maximum 30 seconds (time configurable)
    protected void waitForVisibilityOf(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    // waiting for element until clickable for maximum 30 seconds (time configurable)
    protected void waitForClickAbilityOf(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //For vertical scrolling
    public static void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).press(point(anchor, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(point(anchor, endPoint)).release().perform();
    }
}
