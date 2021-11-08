import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    RegisterPage registerPage;

    @Test(description = "Basarili login", priority = 1)
    public void testCase1(){
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.clickSignUpButton();
        registerPage.getEmail("test@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("12345678");
        registerPage.clickSignUpUserButton();
        registerPage.alertAccept();

        loginPage.clickButtonLogin();
        loginPage.getEmail("test@gmail.com");
        loginPage.getPassword("12345678");
        loginPage.clickButtonLoginUser();
        Assert.assertTrue(loginPage.isDisplayedToolbar());
    }

    @Test(description = "Bos email bos parola validasyon kontrolü", priority = 2)
    public void testCase2(){
        loginPage = new LoginPage(driver);
        loginPage.clickButtonLogin();
        loginPage.clickButtonLoginUser();
        Assert.assertEquals(loginPage.assertText(),"Girdiğiniz email geçersizdir.");
    }

    @Test(description = "Dogru email bos parola kontrolü", priority = 3)
    public void testCase3(){
        loginPage = new LoginPage(driver);
        loginPage.clickButtonLogin();
        loginPage.getEmail("test@gmail.com");
        loginPage.clickButtonLoginUser();
        Assert.assertTrue(loginPage.alertText().contains("Email veya şifre yanlış."));
    }

    @Test(description = "Dogru email yanlis parola kontrolü", priority = 4)
    public void testCase4(){
        loginPage = new LoginPage(driver);
        loginPage.clickButtonLogin();
        loginPage.getEmail("test@gmail.com");
        loginPage.getPassword("123456789");
        loginPage.clickButtonLoginUser();
        Assert.assertTrue(loginPage.alertText().contains("Email veya şifre yanlış."));
    }

    @Test(description = "Yanlis email yanlis parola kontrolü", priority = 5)
    public void testCase5(){
        loginPage = new LoginPage(driver);
        loginPage.clickButtonLogin();
        loginPage.getEmail("test2@gmail.com");
        loginPage.getPassword("123456789");
        loginPage.clickButtonLoginUser();
        Assert.assertTrue(loginPage.alertText().contains("Email veya şifre yanlış."));
    }

}
