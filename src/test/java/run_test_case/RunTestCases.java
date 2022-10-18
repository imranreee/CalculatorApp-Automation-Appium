package run_test_case;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test_cases.*;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunTestCases extends AndroidSettings {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ssaa");
    Date date = new Date();
    String currentDateTime = dateFormat.format(date);


    DateFormat dateFormatNew = new SimpleDateFormat("dd-MMM-yyyy");
    Date dateNew = new Date();
    String currentDate = dateFormatNew.format(dateNew);





    String allureResultPathDes = UserInput.allureReportDestination+ currentDateTime;

    public RunTestCases() throws ParseException {
    }


    @BeforeClass(groups = {"regression", "system"})
    public void setUpAndroid() throws Exception {
        upAndRunApp();
    }

    @BeforeTest(groups = {"regression", "system"})
    public void config() throws Exception {
        File file = new File(UserInput.resultFolderPath + currentDate);
        if (!file.exists()) {
            file.mkdir();
        } else {
            //System.out.println("Unable to make folder");
        }

        File file2 = new File(allureResultPathDes);
        if (!file2.exists()) {
            file2.mkdir();
        } else {
            //System.out.println("Unable to make folder for Allure report");
        }


        htmlReporter = new ExtentSparkReporter(file + "\\CalculatorTestResult_" + UserInput.autVersion + "_" + currentDateTime + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Machine", "Windows");
        extent.setSystemInfo("Platform Name", "Android");
        extent.setSystemInfo("Application Name", "Calculator");
        extent.setSystemInfo("Application Version", UserInput.autVersion);
        extent.setSystemInfo("Script developed by", "Al Imran(imranreee@gmail.com)");

        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Automation Test Results of Calculator"+UserInput.autVersion+" Android App");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Test(priority = 1, enabled = true, groups = {"regression", "system"})
    //For allure report
    /*@Description("Validate add operation")
    @Epic("SSCC-001")
    @Feature("Add operation")
    @Story("SSCC-002")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("SSCL-007")*/
    public void CAL001_ValidateAddOperation(){
        new CAL001_AddOperation(driver).cal001_addOperation();
    }

    @Test(priority = 2, enabled = true, groups = {"regression"})
    /*@Description("Validate sub operation")
    @Epic("SSCC-001")
    @Feature("Sub operation")
    @Story("SSCC-003")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("SSCL-008")*/
    public void CAL002_ValidateSubOperation() throws InterruptedException {
        new CAL002_SubOperation(driver).cal002_subOperation();
    }

    @Test(priority = 3, enabled = true, groups = {"regression", "system"})
    //For allure report
    /*@Description("Multiplication operation")
    @Epic("SSCC-001")
    @Feature("About page")
    @Story("SSCC-003")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("SSCL-009")*/
    public void CAL003_ValidateAboutAndVersion() throws Exception {
        new CAL003_CheckHistory(driver).cal003_checkAboutAndVersion();
    }

    @AfterMethod(groups = {"regression", "system"})
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            GetScreenshot.capture(driver, result.getName() + "_" + currentDateTime);
            String screenShotPath = "./../error_screenshots/"+result.getName() + "_" + currentDateTime+".png";
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath((screenShotPath)).build());
        }

    }

    @AfterTest(groups = {"regression", "system"})
    public void saveReport() {
        extent.flush();
    }

    @AfterClass(groups = {"regression", "system"})
    public void endTest() throws IOException {
        driver.quit();
        MoveFiles.moveFiles(UserInput.allureReportSource, allureResultPathDes);
    }
}
