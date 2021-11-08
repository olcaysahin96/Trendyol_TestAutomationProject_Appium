import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriver driver;

    @BeforeTest
    public void setUp()
    {
        try{
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "Pixel");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformName", "Android");
            cap.setCapability("autoGrantPermissions", "true");
            cap.setCapability("appPackage", "com.example.qaotomation");
            cap.setCapability("appActivity", "com.example.qaotomation.MainActivity");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("****** TEST CASE IS STARTING! ******");
        }
    }

    @AfterTest
    public void tearDown()
    {
        try {
            driver.closeApp();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("****** TEST CASE IS FINISHED! ******");
        }
    }
}
