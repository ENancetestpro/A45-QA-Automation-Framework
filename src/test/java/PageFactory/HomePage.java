package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement firstPlaylist;

    @FindBy(css = "input[type='text']")
    private WebElement playlistInputField;

    @FindBy(css = "div.success.show")
    private WebElement notificationMsg;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void contextClickPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterPlaylistName(String newPlaylistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField));

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String doesPlaylistExist(String playlistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(notificationMsg));
        return notificationMsg.getText();
    }

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
}
