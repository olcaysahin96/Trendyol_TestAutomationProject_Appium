import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Test(description = "Cikis Yap butonu Vazgec kontrolü", priority = 1)
    public void testCase1(){
        homePage = new HomePage(driver);
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

        homePage.clickExitButton();
        homePage.clickNoButton();
        Assert.assertTrue(homePage.isDisplayedExitButton());
    }

    @Test(description = "Cikis Yap kontrolü", priority = 2)
    public void testCase2(){
        homePage = new HomePage(driver);
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

        homePage.clickExitButton();
        homePage.clickYesButton();
        Assert.assertTrue(homePage.isDisplayedLoginButton());
    }

    @Test(description = "Visible Banner kontrolleri", priority = 3)
    public void testCase3(){
        homePage = new HomePage(driver);
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

        Assert.assertTrue(homePage.isDisplayedFirstBanner());
        Assert.assertTrue(homePage.isDisplayedSecondBanner());
        Assert.assertTrue(homePage.isDisplayedThirdBanner());
        Assert.assertTrue(homePage.isDisplayedFourthBanner());
        homePage.scrollDownPage(1);
        Assert.assertTrue(homePage.isDisplayedFifthBanner());
        Assert.assertTrue(homePage.isDisplayedSixthBanner());
        homePage.scrollDownPage(1);
        Assert.assertTrue(homePage.isDisplayedSeventhBanner());
        Assert.assertTrue(homePage.isDisplayedEighthBanner());
        Assert.assertTrue(homePage.isDisplayedNinthBanner());
    }

    @Test(description = "Bugünün tarihi kontrolü", priority = 4)
    public void testCase4(){
        homePage = new HomePage(driver);
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

        homePage.clickDatePicker();
        homePage.alertClickOkButton();
        Assert.assertTrue(homePage.currentDate().contains(homePage.today()));
    }

    @Test(description = "3/11/1980 tarih kontrolü", priority = 5)
    public void testCase5(){
        homePage = new HomePage(driver);
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

        homePage.clickDatePicker();
        homePage.clickYear();
        homePage.goTo3November1980();
        homePage.alertClickOkButton();
        Assert.assertEquals(homePage.assert3November1980(),"03/11/1980");
    }

}
