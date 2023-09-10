import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class Homework26Test extends BaseTest {

    @Test
    public void renamePlaylist() {
        Random random = new Random();
        String playlistName = random.toString();

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterPlaylistName(playlistName);
        String notificationMessage = homePage.doesPlaylistExist(playlistName);
        Assert.assertTrue(notificationMessage.contains(playlistName));
    }
}
