package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.UnitedAirlinePages.UnitedAirlineHomePage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    UnitedAirlineHomePage unitedAirlineHomePage;
    Faker faker;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        unitedAirlineHomePage = new UnitedAirlineHomePage(driver);
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
