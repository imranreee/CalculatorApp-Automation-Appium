package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperClass;

public class CalculatorNormalModePage extends HelperClass {
    private static WebElement element;

    public CalculatorNormalModePage(WebDriver driver) {
        super(driver);
    }

    public static WebElement calculatorTitle(){
        element = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Calculator']"));
        return element;
    }

    public static WebElement btnZero(){
        element = driver.findElement(By.id("btn_0"));
        return element;
    }

    public static WebElement btnOne(){
        element = driver.findElement(By.id("btn_1"));
        return element;
    }

    public static WebElement btnTwo(){
        element = driver.findElement(By.id("btn_2"));
        return element;
    }

    public static WebElement btnThree(){
        element = driver.findElement(By.id("btn_3"));
        return element;
    }

    public static WebElement btnFour(){
        element = driver.findElement(By.id("btn_4"));
        return element;
    }

    public static WebElement btnFive(){
        element = driver.findElement(By.id("btn_5"));
        return element;
    }

    public static WebElement btnSix(){
        element = driver.findElement(By.id("btn_6"));
        return element;
    }

    public static WebElement btnSeven(){
        element = driver.findElement(By.id("btn_7"));
        return element;
    }

    public static WebElement btnEight(){
        element = driver.findElement(By.id("btn_8"));
        return element;
    }

    public static WebElement btnNine(){
        element = driver.findElement(By.id("btn_9"));
        return element;
    }

    public static WebElement btnPlus(){
        element = driver.findElement(By.id("btn_plus"));
        return element;
    }

    public static WebElement btnMinus(){
        element = driver.findElement(By.id("btn_minus"));
        return element;
    }

    public static WebElement btnMulti(){
        element = driver.findElement(By.id("btn_multiply"));
        return element;
    }

    public static WebElement btnDiv(){
        element = driver.findElement(By.id("btn_divide"));
        return element;
    }

    public static WebElement btnEqual(){
        element = driver.findElement(By.id("btn_equals"));
        return element;
    }

    public static WebElement fieldResult(){
        element = driver.findElement(By.id("result"));
        return element;
    }

    public static WebElement fieldFormula(){
        element = driver.findElement(By.id("formula"));
        return element;
    }

    public static WebElement btnClear(){
        element = driver.findElement(By.id("btn_clear"));
        return element;
    }

}
