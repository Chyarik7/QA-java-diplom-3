package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProfilePage {
    private WebDriver driver;
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    public String getLogoutButtonText(){
        return driver.findElement(logoutButton).getText();
    }
}