package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianProfilePage extends BasePage {
    public AtlassianProfilePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeProfilePhoto;
    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputUploadPhoto;
    @FindBy(xpath = "//span[text()='Upload']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='css-1748k3u']")
    WebElement popUpMessage;
    @FindBy(id = "drag-zone-text")
    WebElement popUpWrongFormatImage;


    public void changeMyProfilePhoto(String photoPath) {
        //clickWait(btnProfilePhoto, 3);

        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).pause(2000).click().perform();
        clickWait(btnChangeProfilePhoto, 3);

        File photo = new File(photoPath);
        System.out.println(photo.getAbsolutePath());
        inputUploadPhoto.sendKeys(photo.getAbsolutePath());
        clickWait(btnUpload, 3);
    }

    public boolean validateMessage(String text) {
        return validateTextInElementWait(popUpMessage, text, 8);
    }
    public boolean validateMessageWrongFormatFile(String text) {
        return validateTextInElementWait(popUpWrongFormatImage, text, 8);
    }
}
