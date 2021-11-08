import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage{

    By buttonSignup = By.id("buttonSignup");
    By editTextEmail = By.id("editTextEmail");
    By editTextPassword = By.id("editTextPassword");
    By editTextRePassword = By.id("editTextRePassword");
    By buttonSignupUser = By.id("buttonSignupUser");
    By snackbar_text = By.id("snackbar_text");

    public RegisterPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickSignUpButton(){
        find(buttonSignup).click();
    }

    public void getEmail(String text){
        find(editTextEmail).sendKeys(text);
    }

    public void getPassword(String text) {
        find(editTextPassword).sendKeys(text);
    }

    public void getRePassword(String text) {
        find(editTextRePassword).sendKeys(text);
    }

    public void clickSignUpUserButton() {
        find(buttonSignupUser).click();
    }

    public String successRegisterText() {
        return driver.switchTo().alert().getText();
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public String alertText() {
        return find(snackbar_text).getText();
    }


}
