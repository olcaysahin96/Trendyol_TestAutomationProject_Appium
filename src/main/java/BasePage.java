import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofMillis;

public class BasePage {
    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
    }

    public void webDriverWait(By locator){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement find(By locator){
        webDriverWait(locator);
        return driver.findElement(locator);
    }

    public void actions(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void scrollDown(){
        //find(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100)"));
        Dimension d = driver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
        int swipeStartHeight = (height * 20) / 100;
        int swipeEndHeight = (height * 80) / 100;
        new TouchAction((AndroidDriver) driver)
                .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                .release()
                .perform();
    }

    public List<WebElement> getAllList(By locator){
        return driver.findElements(locator);
    }
}
