package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CalculatorNormalModePage;
import run_test_case.RunTestCases;
import utils.HelperClass;

public class CAL002_SubOperation extends HelperClass {
    public CAL002_SubOperation(WebDriver driver) {
        super(driver);
    }

    public CAL002_SubOperation cal002_subOperation() throws InterruptedException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the sub operation");

        //This is Fluent wait for the specific element
        waitForVisibilityOf(CalculatorNormalModePage.calculatorTitle());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("On the calculator page", ExtentColor.CYAN));

        CalculatorNormalModePage.btnNine().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button nine clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnEight().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button eight clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnZero().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button zero clicked", ExtentColor.CYAN));

        CalculatorNormalModePage.btnMinus().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button minus clicked", ExtentColor.CYAN));

        CalculatorNormalModePage.btnFour().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button four clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnFive().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button five clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnSeven().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button seven clicked", ExtentColor.CYAN));

        String display = "980-457";
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), display);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Digits are displaying as expected "+display, ExtentColor.GREEN));

        CalculatorNormalModePage.btnEqual().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button equal clicked", ExtentColor.CYAN));

        Assert.assertEquals(CalculatorNormalModePage.fieldFormula().getText(), display);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Digits are displaying as expected in formula bar "+display, ExtentColor.GREEN));

        String finalResult = "523";
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), finalResult);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Got final result as expected "+finalResult, ExtentColor.GREEN));

        AndroidTouchAction touch = new AndroidTouchAction ((PerformsTouchActions) driver);
        //press and hold on clear button
        touch.longPress(LongPressOptions.longPressOptions().withElement (ElementOption.element (CalculatorNormalModePage.btnClear()))).perform ();
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), "0");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Clear button action got as expected", ExtentColor.GREEN));

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Sub operation test Passed", ExtentColor.GREEN));

        return new CAL002_SubOperation(driver);
    }
}