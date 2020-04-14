import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    private static WebDriver webDriver = null;

    public static WebDriver createNewDriver(String browser) {

        if (webDriver != null) {
            return webDriver;
        }

        if (CHROME.equals(browser)) {
            webDriver = new ChromeDriver();
        }

        if (FIREFOX.equals(browser)) {
            webDriver = new FirefoxDriver();
        }

        return webDriver;
    }
}