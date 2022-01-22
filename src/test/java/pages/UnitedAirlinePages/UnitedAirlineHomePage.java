package pages.UnitedAirlinePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import texts.ExpectedTextsForUnitedAirLine;

import java.util.List;

public class UnitedAirlineHomePage {
    public UnitedAirlineHomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
}

    public final String departurePoint = "Chicago, IL, US (ORD)";
    public final String destinationPoint = "Miami, FL, US (MIA)";
    public final String flightDate = "Jan 30";

    @FindBy(xpath = "//div[@role='tablist']")
    public WebElement mainHeading;

    @FindBy(xpath = "(//ul)[3]")
    public WebElement bookTravelMenu;

    @FindBy(xpath = "//fieldset[@name='flightType']/div/label")
    public List<WebElement> tripRadioButtons;

    @FindBy(xpath = "//fieldset[@name='flightType']/div/label/input")
    public List<WebElement> tripRadioButtonsInput;

    @FindBy(xpath = "//div[contains(@class, 'app-components-BookFlightForm-bookFlightForm__c')]/label")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[contains(@class, 'app-components-BookFlightForm-bookFlightForm__c')]/input")
    public List<WebElement> checkBoxesInput;

    @FindBy(xpath = "//div[contains(@class, 'ripOriginDestinatio')]")
    public WebElement destination;

    @FindBy(xpath = "//input[contains(@class, 'app-components-Q')]")
    public List<WebElement> departureAndDestinationInput;

    @FindBy(id = "DepartDate")
    public WebElement travelDate;

    @FindBy(css = "div#passengerSelector>button")
    public WebElement passengerAmountButton;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement passengerPlusButton;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(xpath = "//li[@id='cabinType_item-2']")
    public WebElement businessOrFirst;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement findFlightsButton;

    public void clickOnBoxes(){
        for(WebElement checkBox: checkBoxes){
            checkBox.click();
        }
    }

    public void findTicket() {
        clickRadioButtons(ExpectedTextsForUnitedAirLine.onewayButton);
        departureAndDestinationInput.get(0).clear();
        departureAndDestinationInput.get(0).sendKeys(departurePoint);
        departureAndDestinationInput.get(1).clear();
        departureAndDestinationInput.get(1).sendKeys(destinationPoint);
        travelDate.clear();
        travelDate.click();
        travelDate.sendKeys(flightDate);
        passengerAmountButton.click();
        passengerPlusButton.click();
        cabinType.click();
        businessOrFirst.click();
        findFlightsButton.click();
    }

    public void clickRadioButtons(String radioButtonText){
        for(WebElement radioButton: tripRadioButtons){
            if(radioButton.getText().equals(radioButtonText)) {
                radioButton.click();
                return;
            }
        }
    }
}

