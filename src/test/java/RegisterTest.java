import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest{

    RegisterPage registerPage;

    @Test (description = "Basarili Kullanıcı Kayıt İslemi", priority = 1)
    public void testCase1(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.getEmail("test@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("12345678");
        registerPage.clickSignUpUserButton();
        Assert.assertTrue(registerPage.successRegisterText().contains("Başarılı şekilde kayıt oldun."));
    }

    @Test (description = "Bos Email bos parola validasyon kontrolü", priority = 2)
    public void testCase2(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.clickSignUpUserButton();
        Assert.assertEquals(registerPage.alertText(),"Girdiğiniz email geçersizdir. Lütfen geçerli bir email girin.");
    }

    @Test (description = "Özel karakter Email validasyon kontrolü", priority = 3)
    public void testCase3(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.getEmail("!'^+%&/$(){}[]=?<>@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("12345678");
        registerPage.clickSignUpUserButton();
        Assert.assertEquals(registerPage.alertText(),"Girdiğiniz email geçersizdir. Lütfen geçerli bir email girin.");
    }


    @Test (description = "Parola en az 8 karakterden olusmalıdır validasyon kontrolü", priority = 4)
    public void testCase4(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.getEmail("test@gmail.com");
        registerPage.getPassword("1234567");
        registerPage.getRePassword("1234567");
        registerPage.clickSignUpUserButton();
        Assert.assertEquals(registerPage.alertText(),"En az sekiz karakterden oluşan bir şifre belirleyin.");
    }

    @Test (description = "Parola eslesme validasyon kontrolü", priority = 5)
    public void testCase5(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.getEmail("test@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("123456789");
        registerPage.clickSignUpUserButton();
        Assert.assertEquals(registerPage.alertText(),"Şifreler eşleşmiyor, lütfen tekrar kontrol edin.");
    }

    @Test (description = "Ayni Email adresi ile kayit olamama kontrolü", priority = 6)
    public void testCase6(){
        registerPage = new RegisterPage(driver);
        registerPage.clickSignUpButton();
        registerPage.getEmail("olcay@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("12345678");
        registerPage.clickSignUpUserButton();
        registerPage.alertAccept();
        registerPage.clickSignUpButton();
        registerPage.getEmail("olcay@gmail.com");
        registerPage.getPassword("12345678");
        registerPage.getRePassword("12345678");
        registerPage.clickSignUpUserButton();
        Assert.assertEquals(registerPage.alertText(),"Bu mail bir kullanıcı tarafından kullanılıyor.");
    }




}
