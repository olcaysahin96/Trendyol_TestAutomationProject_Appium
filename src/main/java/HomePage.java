import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class HomePage extends BasePage{
    LoginPage loginPage = new LoginPage(driver);
    By action_logout = By.id("action_logout");
    By yesButton = By.id("android:id/button1");
    By noButton = By.id("android:id/button2");
    By datePicker = By.id("overlayDatePicker");
    By datePickerOkButton = By.xpath("//*[@text='OK']");
    By year = By.id("android:id/date_picker_header_year");
    By dateAnimator = By.id("android:id/date_picker_year_picker");
    By november1980 = By.xpath("//android.view.View[@content-desc=\"03 November 1980\"]");
    By editTextDatePicker = By.id("editTextDatePicker");
    By firstBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
    By secondBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
    By thirdBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
    By fourthBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]");
    By fifthBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]");
    By sixthBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]");
    By seventhBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]");
    By eighthBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]");
    By ninthBanner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[9]");

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    protected void clickExitButton() {
        find(action_logout).click();
    }

    protected void clickNoButton() {
        driver.switchTo().alert();
        find(noButton).click();
    }

    protected void clickYesButton() {
        driver.switchTo().alert();
        find(yesButton).click();
    }

    protected boolean isDisplayedExitButton() {
        return find(action_logout).isDisplayed();
    }

    protected boolean isDisplayedLoginButton() {
        return find(loginPage.buttonLogin).isDisplayed();
    }

    protected void clickDatePicker() {
        find(datePicker).click();
    }

    protected void alertClickOkButton() {
        find(datePickerOkButton).click();
    }

    protected String currentDate() {
        Date today  = new Date(System.currentTimeMillis());
        return today.toString();
    }

    protected String today() {
        return find(datePicker).getText();
    }

    protected void clickYear() {
        find(year).click();
    }

    protected void goTo3November1980(){
        WebElement element = driver.findElement(dateAnimator);
        actions(element);
        for(int i=1; i<=45; i++) {
            driver.getKeyboard().sendKeys(Keys.ARROW_UP);
        }
        find(dateAnimator).click();
        find(november1980).click();
    }

    protected String assert3November1980() {
        return find(editTextDatePicker).getText();
    }

    protected boolean isDisplayedFirstBanner() {
        checkBannerSize(firstBanner);
        return find(firstBanner).isDisplayed();
    }
    protected boolean isDisplayedSecondBanner() {
        checkBannerSize(secondBanner);
        return find(secondBanner).isDisplayed();
    }
    protected boolean isDisplayedThirdBanner() {
        checkBannerSize(thirdBanner);
        return find(thirdBanner).isDisplayed();
    }
    protected boolean isDisplayedFourthBanner() {
        checkBannerSize(fourthBanner);
        return find(fourthBanner).isDisplayed();
    }
    protected boolean isDisplayedFifthBanner() {
        checkBannerSize(fifthBanner);
        return find(fifthBanner).isDisplayed();
    }
    protected boolean isDisplayedSixthBanner() {
        checkBannerSize(sixthBanner);
        return find(sixthBanner).isDisplayed();
    }
    protected boolean isDisplayedSeventhBanner() {
        checkBannerSize(seventhBanner);
        return find(seventhBanner).isDisplayed();
    }
    protected boolean isDisplayedEighthBanner() {
        checkBannerSize(eighthBanner);
        return find(eighthBanner).isDisplayed();
    }
    protected boolean isDisplayedNinthBanner() {
        checkBannerSize(ninthBanner);
        return find(ninthBanner).isDisplayed();
    }

    protected boolean checkBannerSize(By locator){
         return getAllList(locator).size() > 0;
    }

    protected void scrollDownPage(int xTimes) {
        for (int i=1; i<=xTimes; i++)
        scrollDown();
    }

}
