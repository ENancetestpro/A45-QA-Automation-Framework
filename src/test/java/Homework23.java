import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String playlistName = "PlayMusic";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterPlaylistName(playlistName);
        String notificationMessage = homePage.doesPlaylistExist(playlistName);
        Assert.assertTrue(notificationMessage.contains(playlistName));
    }
}
