package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidSettings {
    protected WebDriver driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    //String UDID = "";

    public void upAndRunApp() throws Exception {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        appiumService.clearOutPutStreams();

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "android");
        dc.setCapability("deviceName", "OnePlusOne");
        dc.setCapability("noReset", true);
        dc.setCapability("autoGrantPermissions", true);
        //For running on specific device
        //dc.setCapability("udid", UDID);
        dc.setCapability("appPackage", "com.simplemobiletools.calculator");
        dc.setCapability("appActivity", "com.simplemobiletools.calculator.activities.SplashActivity.Orange");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
    }
}
