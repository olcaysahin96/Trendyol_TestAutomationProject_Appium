import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    By buttonLogin = By.id("buttonLogin");
    By editTextEmail = By.id("editTextEmail");
    By editTextPassword = By.id("editTextPassword");
    By buttonLoginUser = By.id("buttonLoginUser");
    By snackbarText = By.id("snackbar_text");
    By toolbarListing = By.id("toolbar_listing");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickButtonLogin() {
        find(buttonLogin).click();
    }

    public void getEmail(String text) {
        find(editTextEmail).sendKeys(text);
    }

    public void getPassword(String text) {
        find(editTextPassword).sendKeys(text);
    }

    public void clickButtonLoginUser() {
        find(buttonLoginUser).click();
    }

    public String assertText() {
        return find(snackbarText).getText();
    }

    public String alertText() {
        return driver.switchTo().alert().getText();
    }

    public boolean isDisplayedToolbar() {
        return find(toolbarListing).isDisplayed();
    }
}
