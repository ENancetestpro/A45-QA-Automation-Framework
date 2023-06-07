package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final By firstPlaylist = By.cssSelector("#playlists > ul > li:nth-child(3) > a");
    private final By playlistInputField = By.cssSelector("[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void contextClickPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterPlaylistName(String newPlaylistName) {
        WebElement playlistInputFieldElement = findElement(playlistInputField);
        playlistInputFieldElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputFieldElement.sendKeys(newPlaylistName);
        playlistInputFieldElement.sendKeys(Keys.ENTER);
    }

    public String doesPlaylistExist(String playlistName) {
        By notificationMsg = By.cssSelector("div.success.show");
        return findElement(notificationMsg).getText();
    }

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
}
