import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.MailRuLoginPage;
import pageobjects.MailRuMailPage;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

/**
 * Created by EugenBorisik on 4/6/2017.
 */
public class LogIn {
    private static final String ENTER = "Вход";
    private static final String EXIT = "выход";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage(driver);
        mailRuLoginPage.load();
        MailRuMailPage mailRuMailPage = mailRuLoginPage.login();
        assertEquals(mailRuMailPage.getExitValue(), EXIT);
    }

    @Test
    public void logout() throws InterruptedException {
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage(driver);
        mailRuLoginPage.load();
        MailRuMailPage mailRuMailPage = mailRuLoginPage.login();
        mailRuLoginPage = mailRuMailPage.logout();
        assertEquals(mailRuLoginPage.getEnterValue(), ENTER);
    }
}
