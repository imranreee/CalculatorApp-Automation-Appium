package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CalculatorNormalModePage;
import run_test_case.RunTestCases;
import utils.HelperClass;

public class CAL001_AddOperation extends HelperClass {
    public CAL001_AddOperation(WebDriver driver) {
        super(driver);
    }

    public CAL001_AddOperation cal001_addOperation() {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the add operation");

        //This is Fluent wait for the specific element
        waitForVisibilityOf(CalculatorNormalModePage.calculatorTitle());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("On the calculator page", ExtentColor.CYAN));

        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), "0");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Default value in result field got as expected", ExtentColor.GREEN));

        Assert.assertEquals(CalculatorNormalModePage.calculatorTitle().getText(), "Calculator");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Calculator title found", ExtentColor.GREEN));

        CalculatorNormalModePage.btnOne().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button one clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnTwo().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button two clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnThree().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button three clicked", ExtentColor.CYAN));

        CalculatorNormalModePage.btnPlus().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button plus clicked", ExtentColor.CYAN));

        CalculatorNormalModePage.btnFour().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button four clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnFive().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button five clicked", ExtentColor.CYAN));
        CalculatorNormalModePage.btnSix().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button six clicked", ExtentColor.CYAN));

        String display = "123+456";
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), display);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Digits are displaying as expected "+display, ExtentColor.GREEN));

        CalculatorNormalModePage.btnEqual().click();
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Button equal clicked", ExtentColor.CYAN));

        Assert.assertEquals(CalculatorNormalModePage.fieldFormula().getText(), display);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Digits are displaying as expected in formula bar "+display, ExtentColor.GREEN));

        String finalResult = "579";
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), finalResult);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Got final result as expected "+finalResult, ExtentColor.GREEN));

        AndroidTouchAction touch = new AndroidTouchAction ((PerformsTouchActions) driver);
        //press and hold on clear button
        touch.longPress(LongPressOptions.longPressOptions().withElement (ElementOption.element (CalculatorNormalModePage.btnClear()))).perform ();
        Assert.assertEquals(CalculatorNormalModePage.fieldResult().getText(), "0");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Clear button action got as expected", ExtentColor.GREEN));

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Add operation test Passed", ExtentColor.GREEN));
        return new CAL001_AddOperation(driver);
    }
}