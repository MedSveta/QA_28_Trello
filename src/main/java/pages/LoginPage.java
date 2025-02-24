package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }

    @FindBy(id = "username")
    WebElement inputEmail;
    @FindBy(id = "login-submit")
    WebElement btnContinue;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "login-submit")
    WebElement btnLogin;

    public void login(User user) {
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
        clickWait(inputPassword, 5);
        inputPassword.sendKeys(user.getPassword());
        btnLogin.click();
    }
}
