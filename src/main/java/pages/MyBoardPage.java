package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage {
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    @FindBy(xpath = "//button[@aria-label='Show menu']")
    WebElement btnMenuDots;
    @FindBy(xpath = "//div[text()='Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnCloseConfirm;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDeleteConfirm;

    public void deleteBoard() {
    clickWait(btnMenuDots, 3);
    clickWait(btnCloseBoard, 3);
    clickWait(btnCloseConfirm, 3);
    clickWait(btnDeleteBoard, 3);
    clickWait(btnDeleteConfirm, 3);
    }

    public boolean validateBoardName(String text, int time) {
        return validateTextInElementWait(boardName, text, time);
    }
}
