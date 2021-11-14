import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

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
