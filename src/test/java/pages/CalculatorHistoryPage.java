package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperClass;

public class CalculatorHistoryPage extends HelperClass {
    private static WebElement element;

    public CalculatorHistoryPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement btnHistory(){
        element = driver.findElement(By.id("history"));
        return element;
    }

    public static WebElement btnClear(){
        element = driver.findElement(By.id("android:id/button3"));
        return element;
    }

    public static WebElement textHistoryDialogTitle(){
        element = driver.findElement(By.id("dialog_title_textview"));
        return element;
    }

    public static WebElement textCalculateHistory(){
        element = driver.findElement(By.xpath("//android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
        return element;
    }


}
