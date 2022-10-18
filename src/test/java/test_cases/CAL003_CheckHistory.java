package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.lang3.time.CalendarUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CalculatorHistoryPage;
import run_test_case.RunTestCases;
import utils.HelperClass;

public class CAL003_CheckHistory extends HelperClass {
    public CAL003_CheckHistory(WebDriver driver) {
        super(driver);
    }

    public CAL003_CheckHistory cal003_checkAboutAndVersion() throws Exception {
        RunTestCases.test = RunTestCases.extent.createTest("Validate about page and version");

        waitForClickAbilityOf(CalculatorHistoryPage.btnHistory());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Found history button", ExtentColor.CYAN));

        CalculatorHistoryPage.btnHistory().click();
        waitForVisibilityOf(CalculatorHistoryPage.textHistoryDialogTitle());
        Assert.assertEquals(CalculatorHistoryPage.textHistoryDialogTitle().getText(), "History");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("History button action as expected", ExtentColor.GREEN));

        Assert.assertEquals(CalculatorHistoryPage.textCalculateHistory().getText(), "520");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Got history as expected", ExtentColor.GREEN));

        CalculatorHistoryPage.btnClear().click();
        waitForClickAbilityOf(CalculatorHistoryPage.btnHistory());
        CalculatorHistoryPage.btnHistory().click();
        if (driver.findElements(By.id("dialog_title_textview")).size() > 0){
            Assert.assertEquals(1,0);
        }else {
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Clear history button action got as expected", ExtentColor.GREEN));
        }

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Check history test passed", ExtentColor.GREEN));
        return new CAL003_CheckHistory(driver);
    }
}