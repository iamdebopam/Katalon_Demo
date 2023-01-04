package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.makeAnAppointmentPage;
import pageObjects.login;
import resources.Base;
import resources.excelReader;

public class stepDefinitions extends Base {
    private Scenario scenario;
    private login ln;
    private makeAnAppointmentPage mp;

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
    }

    @After
    public void after(Scenario scenario){
        this.scenario=scenario;
        if(scenario.isFailed()){
            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","error!!");
        }
    }
    @Given("Initialize the driver")
    public void initializeTheDriver() {
        initializeDriver();
        ln=new login(driver);
        mp=new makeAnAppointmentPage(driver);
    }

    @And("user navigates to page")
    public void userNavigatesToPage() {
        String home= prop.getProperty("url");
        driver.get(home);
    }

    @And("click on make appointment")
    public void clickOnMakeAppointment() throws InterruptedException {

        ln.getMakeAppointment().click();

    }
    

    @And("click on Login")
    public void clickOnLogin() {
        ln.getClickLogin().click();
    }


    @And("close the browser")
    public void closeTheBrowser() {
        driver.close();
    }

    @When("enters credentials username {string} and password {string}")
    public void entersCredentialsUsernameAndPassword(String arg0, String arg1) {
        ln.getUsername().sendKeys(arg0);
        ln.getPassword().sendKeys(arg1);
    }


    @When("enters invalid credentials username {string} and password {int}")
    public void entersInvalidCredentialsUsernameAndPasswordRowNumber(String sheetName,int rowNumber) {
        excelReader er =new excelReader();
        Row row= er.getRowBySheetAndIndex(sheetName,rowNumber);
        String userName= er.getCellValue(row,0);
        String password= er.getCellValue(row,1);
        ln.getUsername().sendKeys(userName);
        ln.getPassword().sendKeys(password);
    }

    @Then("Verify if the account is logged in successfully with valid credentials")
    public void verifyIfTheAccountIsLoggedInSuccessfullyWithValidCredentials() {
        String str=ln.getSuccessfulLoginCheck().getText();
        String str1="Make Appointment";
        Assert.assertEquals(str1,str);
    }

    @Then("Verify if the account is logged in successfully with invalid credentials")
    public void verifyIfTheAccountIsLoggedInSuccessfullyWithInvalidCredentials() {
        String str=ln.getUnsuccessfulLoginCheck().getText();
        String str1="Login failed! Please ensure the username and password are valid.";
        Assert.assertEquals(str1,str);
    }

    @When("User chooses a facility for the appointment")
    public void userChoosesAFacilityForTheAppointment() {
        Select select = new Select(mp.getFacilityDropdown());
        select.selectByValue(prop.getProperty("facility"));
    }

    @And("User chooses a healthcare program")
    public void userChoosesAHealthcareProgram() {
        mp.getHealthcareRadio(prop.getProperty("healthcare")).click();
    }

    @And("User provides a date for the appointment")
    public void userProvidesADateForTheAppointment() {
        mp.getVisitDateField().sendKeys(prop.getProperty("date"));
    }

    @And("User clicks the book appointment button")
    public void userClicksTheBookAppointmentButton() {
        mp.getBookAppointmentButton().click();
    }

    @Then("Appointment gets booked successfully")
    public void appointmentGetsBookedSuccessfully() {
        String actual = mp.getAppointmentConfirmationHeader().getText();
        String expected = prop.getProperty("confirmationMessage");
        Assert.assertEquals(expected, actual);
    }

    @And("Booking information matches with confirmation information")
    public void bookingInformationMatchesWithConfirmationInformation() {
        Assert.assertEquals(mp.getBookedFacility().getText(), prop.getProperty("facility"));
        Assert.assertEquals(mp.getBookedHealthcare().getText(), prop.getProperty("healthcare"));
        Assert.assertEquals(mp.getBookedVisitDate().getText(), prop.getProperty("date"));
    }
}