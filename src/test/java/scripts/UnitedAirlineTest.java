package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import texts.ExpectedTextsForUnitedAirLine;
import utilities.ConfigReader;

public class UnitedAirlineTest extends Base {

    @Test(testName = "Validate Main menu navigation items", priority = 1)
    public void validateMainMenu() {
        driver.get(ConfigReader.getProperty("unitedAirlineURL"));
        Assert.assertTrue(unitedAirlineHomePage.mainHeading.isDisplayed(), ExpectedTextsForUnitedAirLine.mainMenuAuthentication);
    }

    @Test(testName = "Validate book travel menu navigation items", priority = 2)
    public void validateBookTravelMenu() {
        driver.get(ConfigReader.getProperty("unitedAirlineURL"));
        Assert.assertTrue(unitedAirlineHomePage.bookTravelMenu.isDisplayed(), ExpectedTextsForUnitedAirLine.bookTravelMenu);
    }

    @Test(testName = "Validate Round-Trip and One-way radio buttons", priority = 3)
    public void validateRoundWayAndOnewayButtons() {
        driver.get(ConfigReader.getProperty("unitedAirlineURL"));

        for (WebElement radioButton : unitedAirlineHomePage.tripRadioButtons) {
            Assert.assertTrue(radioButton.isDisplayed());
            Assert.assertTrue(radioButton.isEnabled());
        }

        Assert.assertTrue(unitedAirlineHomePage.tripRadioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedAirlineHomePage.tripRadioButtonsInput.get(1).isSelected());

        unitedAirlineHomePage.clickRadioButtons(ExpectedTextsForUnitedAirLine.onewayButton);
        Assert.assertFalse(unitedAirlineHomePage.tripRadioButtonsInput.get(0).isSelected());
    }

    @Test(testName = "Validate Book with miles and FlexibleDates checkboxes", priority = 4)
    public void validateBookWithMileNFlexDates() {
        driver.get(ConfigReader.getProperty("unitedAirlineURL"));

        for (int i = 0; i < unitedAirlineHomePage.checkBoxes.size(); i++) {
            Assert.assertTrue(unitedAirlineHomePage.checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlineHomePage.checkBoxes.get(i).isEnabled());
            Assert.assertFalse(unitedAirlineHomePage.checkBoxesInput.get(i).isSelected());
        }

        unitedAirlineHomePage.clickOnBoxes();
        for (WebElement checkBox : unitedAirlineHomePage.checkBoxesInput) {
            Assert.assertTrue(checkBox.isSelected());
        }

        unitedAirlineHomePage.clickOnBoxes();
        for (WebElement checkBox : unitedAirlineHomePage.checkBoxesInput) {
            Assert.assertFalse(checkBox.isSelected());
        }
    }

    @Test(testName = "Validate One-way search result from ORD to MIA",priority = 5)
    public void ValidateOneWayResultFromOrdToMia() {
        driver.get(ConfigReader.getProperty("unitedAirlineURL"));

        unitedAirlineHomePage.findTicket();
        Assert.assertEquals(unitedAirlineHomePage.destination.getText(), ExpectedTextsForUnitedAirLine.departInfo);
    }
}


