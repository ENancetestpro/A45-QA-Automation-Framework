
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomework20 extends BaseTest {

    //Prerequisite - empty playlist to delete
    @Test
    public void deletePlaylistTest() {
        String deletedPlaylistMsg = "Delete the playlist";
        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        submit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }

    public void openPlaylist() {
        WebElement oldPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#playlists li:nth-child(3) > a")));
        oldPlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlistWrapper button.del.btn-delete-playlist")));
        deletePlaylist.click();
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(@class, 'msg') and contains(text(), 'Delete the playlist')]")));
        return notificationMsg.getText();
    }

}
