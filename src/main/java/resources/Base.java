package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    protected Properties prop;

    public void initializeDriver() {
        prop = new Properties();

        try {
            FileInputStream fs = new FileInputStream("src/main/java/resources/data.properties");
            prop.load(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String chromedriverPath = prop.getProperty("path");
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        driver = new ChromeDriver();
        //int i = 10;
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((i)));
    }
}
