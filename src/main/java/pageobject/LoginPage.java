package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath(".//label[text()='Email']/../input");
    private By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By registerButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    private By forgotPasswordButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Восстановить пароль')]");
    private By loginLabelText = By.xpath(".//h2[text()='Вход']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }
    public String getLoginLabelText() {
        return driver.findElement(loginLabelText).getText();
    }
    public void setUserLoginInfo(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
    }

}