import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;
import user.User;
import user.UserDataGenerator;
import user.UserSteps;
import user.UserLogin;
import pageobject.LoginPage;
import pageobject.RegisterPage;

import java.time.Duration;

public class UserRegisterTest {
    public WebDriver driver;
    private User user;
    private String accessToken;
    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        driver = new ChromeDriver(options);
        driver.get(UserSteps.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));

    }
    @Test
    @DisplayName("Регистрация пользователя")
    public void registerNewUserTest() {
        user = UserDataGenerator.getRandomUser();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registerPage.setUserInfo(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        String text = loginPage.getLoginLabelText();
        Assert.assertEquals("Вход", text);
        UserLogin login = new UserLogin(user.getEmail(), user.getPassword());
        RestAssured.baseURI = UserSteps.baseURL;
        accessToken = UserSteps.loginUser(login).then().extract().path("accessToken");
    }
    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    public void registerNewUserWithWrongPasswordTest() {
        user = UserDataGenerator.getRandomUserWithWrongPassword();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registerPage.setUserInfo(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        String text = registerPage.getPasswordErrorText();
        Assert.assertEquals("Некорректный пароль", text);
    }
    @After
    public void tearDown(){
        driver.quit();
        if (accessToken != null) {
            UserSteps.deleteUser(accessToken);
        }
    }
}