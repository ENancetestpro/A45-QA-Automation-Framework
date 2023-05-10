
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    //Prerequisite - empty playlist to delete
    @Test
    public void deletePlaylistTest() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";

        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }

    public void openPlaylist() throws InterruptedException {
        WebElement oldPlaylist = driver.findElement(By.cssSelector("section#playlists li:nth-child(3) > a"));
        oldPlaylist.click();
    }

    public void clickDeletePlaylistBtn()  throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("#playlistWrapper button.del.btn-delete-playlist"));
        deletePlaylist.click();
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.alertify div.dialog p.msg"));
        return notificationMsg.getText();
    }

}
