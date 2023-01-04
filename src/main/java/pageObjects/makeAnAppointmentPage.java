package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class makeAnAppointmentPage {

    public final WebDriver driver;

    public final By bookedFacility = By.id("facility");
    public final By bookedHealthcare = By.id("program");
    public final By bookedVisitDate = By.id("visit_date");
    public final By visitDateField = By.id("txt_visit_date");
    public final By facilityDropdown = By.id("combo_facility");
    public final By bookAppointmentButton = By.id("btn-book-appointment");
    public final By makeAppointmentHeader = By.xpath("//h2[contains(text(), 'Make Appointment')]");
    public final By appointmentConfirmationHeader = By.xpath("//h2[contains(text(), 'Appointment Confirmation')]");

    public makeAnAppointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getMakeAppointmentHeader(){
        return driver.findElement(makeAppointmentHeader);
    }

    public WebElement getAppointmentConfirmationHeader() {
        return driver.findElement(appointmentConfirmationHeader);
    }

    public WebElement getFacilityDropdown() {
        return driver.findElement(facilityDropdown);
    }

    public WebElement getHealthcareRadio(String value) {
        return driver.findElement(By.id(String.format("radio_program_%s", value.toLowerCase())));
    }

    public WebElement getVisitDateField() {
        return driver.findElement(visitDateField);
    }

    public WebElement getBookAppointmentButton() {
        return driver.findElement(bookAppointmentButton);
    }

    public WebElement getBookedFacility() {
        return driver.findElement(bookedFacility);
    }

    public WebElement getBookedHealthcare() {
        return driver.findElement(bookedHealthcare);
    }

    public WebElement getBookedVisitDate() {
        return driver.findElement(bookedVisitDate);
    }
}
