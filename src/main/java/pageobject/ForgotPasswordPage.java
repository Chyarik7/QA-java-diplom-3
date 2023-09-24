package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By loginButton = By.xpath(".//a[text()='Войти']");
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}