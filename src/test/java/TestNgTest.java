import driver.DriverFactory;
import driver.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestNgTest {
    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    @BeforeTest
    public void open() throws Exception {
        driver = DriverFactory.getNewInstance("chrome");
        DriverHolder.setDriver(driver);
        // open the given url
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest(){
        driver.get("https://www.saucedemo.com/");
        loginPage=new LoginPage(driver);
        loginPage.enterEmail("standard_user").enterPassword("secret_sauce").clickOnLoginButton();
        homePage=new HomePage(driver);
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.homePageLoaded());
//test
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }

}
