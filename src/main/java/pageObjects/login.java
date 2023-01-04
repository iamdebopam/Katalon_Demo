package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login extends Exception {
    public WebDriver driver;

    public login(WebDriver driver){this.driver=driver;}

    public final By makeAppointment = By.id("btn-make-appointment");
    public final By username = By.xpath("//*[@id=\"txt-username\"]");
    public final By password = By.xpath("//*[@id=\"txt-password\"]");
    public final By clickLogin = By.xpath("//*[@id=\"btn-login\"]");
    public final By unSuccessfulLoginCheck = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]");

    public final By successfulLoginCheck = By.xpath("//*[@id=\"appointment\"]/div/div/div/h2");

    public WebElement getMakeAppointment() { return driver.findElement(makeAppointment);}
    public WebElement getUsername() {return driver.findElement(username);}
    public WebElement getPassword() {return driver.findElement(password);}
    public WebElement getClickLogin() {return driver.findElement(clickLogin);}

    public WebElement getSuccessfulLoginCheck() {return driver.findElement(successfulLoginCheck);}
    public WebElement getUnsuccessfulLoginCheck() {return driver.findElement(unSuccessfulLoginCheck);}
}
