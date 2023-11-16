package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties props = new Properties();

    public Base() {
        try {
            String PathOfConfigFile = "src/main/java/Properties/config.properties";
            File file = new File(PathOfConfigFile);
            FileInputStream FIS = new FileInputStream(file);
            props.load(FIS);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected static void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void launchBrowser() {
        String browser = props.getProperty("browser");
        // System.out.println(browser);
        if ("chrome".equalsIgnoreCase(browser)) {
            LaunchChromeDriver();
        } else {
            if ("firefox".equalsIgnoreCase(browser)) {
                LaunchFirefoxDriver();
            } else {
                LaunchChromeDriver();
            }
        }
    }

    public static void CloseBrowser() {
        driver.quit();
    }

    public static void LaunchChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String CRR = props.getProperty("url");
        // System.out.println(CRR);
        if (CRR != null) {
            driver.get(CRR);
        } else {

            System.out.println("L'URL est nulle.");
        }

    }

    public static void LaunchFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        String URL = props.getProperty("url");
        if (URL != null) {
            driver.get(URL);
        } else {

            System.out.println("L'URL est nulle.");
        }

    }

}
