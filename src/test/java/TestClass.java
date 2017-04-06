import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by EugenBorisik on 4/6/2017.
 */
public class TestClass {

    @Test
    public void t() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mail.ru");
        driver.close();
    }
}
