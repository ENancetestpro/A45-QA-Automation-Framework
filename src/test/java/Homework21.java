import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
String newPlaylistName = "PlayMusic";
    @Test
    public void renamePlaylist() {
        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        submit();
        contextClickChosenPlaylist();
        clickEditBtn();
        provideNewPlaylistName();
        doesPlaylistExist();
        //Assert.assertTrue(doesPlaylistExist());
    }

    public void contextClickChosenPlaylist()
    { wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        WebElement firstPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        actions.contextClick(firstPlaylist).perform(); }

    private void clickEditBtn()
    { wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")));
        driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")).click(); }

        public void provideNewPlaylistName()
        { WebElement playlistInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='name']")));
            playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            playlistInputField.sendKeys(newPlaylistName);
            playlistInputField.sendKeys(Keys.ENTER);}

    public String doesPlaylistExist()
    { WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText(); }
    }

