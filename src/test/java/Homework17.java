import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.sendKeys("Ketsa");


        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();
        Thread.sleep(1000);


        WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        addToButton.click();
        Thread.sleep(1000);


        WebElement addToPlaylistButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        addToPlaylistButton.click();
        Thread.sleep(1000);


        WebElement newPlaylistButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'party playlist')]"));
        newPlaylistButton.click();
        Thread.sleep(2000);


        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"party playlist.\"");
    }
}