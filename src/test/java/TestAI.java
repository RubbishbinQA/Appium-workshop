import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestAI {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus_6_API_28");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.soundcloud.android");
        caps.setCapability("appActivity","com.soundcloud.android.main.MainActivity");
        caps.setCapability("noReset","false");

        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");

        caps.setCapability("customFindModules", customFindModules);
        caps.setCapability("shouldUseCompactResponses", false);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 25);
    }

    @Test
    public void basicTest () {

        By search = MobileBy.custom("search");
        By home   = MobileBy.custom("home");

        driver.findElement(home).click();
        driver.findElement(search).click();
        driver.findElement(home).click();
        driver.findElement(search).click();
        driver.findElement(home).click();
        driver.findElement(search).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.soundcloud.android:id/search_edit_text"))).sendKeys("Dj Snake "+"\n");

        String people = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"PEOPLE\"]";

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(people))).click();

        String result = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ViewFlipper/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout";

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(result))).click();

        String name = "DJ SNAKE";

        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.soundcloud.android:id/username")));

        Assert.assertEquals(userName.getText(), name);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}