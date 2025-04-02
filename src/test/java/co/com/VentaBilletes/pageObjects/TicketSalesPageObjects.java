package co.com.VentaBilletes.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;


public class TicketSalesPageObjects extends PageObject {

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    static WebElementFacade btnAcceptCookies;

    @FindBy(xpath="//input[@id='TripTypeRoundtrip']")
    static WebElementFacade btnIdaVuelta;

    @FindBy(xpath="//input[@id='departureRoundtrip0']")
    static WebElementFacade strOrigin;

    @FindBy(xpath="//ul[@class='hide-medium']//li//a[contains(text(),'Madrid')]")
    static WebElementFacade lblSelector2;
    @FindBy(xpath="//input[@id='arrivalOneway']")
    static WebElementFacade strDestination;

    @FindBy(xpath="//a[@id='DropDownListPassengerType_ADT_PLUS']")
    static WebElementFacade strNumberAdults;
    //*[@id="uc-center-container"]
    @FindBy(xpath="//select[@id='AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD']")
    static WebElementFacade strNumberChildren;

    @FindBy(xpath="//div[@id='divButtonBuscadorNormal']//span[@class='bt_link' and contains(text(),'Buscar vuelos')]")
    static WebElementFacade btnBuscarVuelos;

    private static final By listOutboundFlight = By.xpath("//div[@data-js-id='stvJourney'][1]//div[@id='outboundFlightCardsContainer']//div[@data-js-id='flightCard']");

    private static final By listReturnFlight = By.xpath("//div[@data-js-id='stvJourney'][2]//div[@id='inboundFlightCardsContainer']//div[@data-js-id='flightCard']");

    private static final By lblMensaje = By.xpath("//div[@id='passengersInformationBox']//div[@class='alert__message']");

    private static By btnDayDeparture;
    private static By btnDayReturn;
    private static By lblSelectorCityOrigin;
    private static By lblSelectorCityDestination;
    private static By listNumberAdults;
    private static By listNumberChildren;
    private static By listTariff;

    public WebElementFacade getBtnAcceptCookies() {
        return btnAcceptCookies;
    }

    public WebElementFacade getBtnIdaVuelta(){
        return btnIdaVuelta;
    }
    public WebElementFacade getStrOrigin() {
        return strOrigin;
    }

    public static void setLblSelectorCityOrigin(String city) {
        lblSelectorCityOrigin = By.xpath("//div[@class='wrapper_dropDown wrapper_dropDown--buscador cajaDesplegableTabToggle']//li//a[contains(text(),'*')]".replace("*", city));
    }

    public By getLblSelectorCityOrigin(){
        return lblSelectorCityOrigin;
    }

    public static void setLblSelectorCityDestination(String city) {
        lblSelectorCityDestination = By.xpath("//ul[@class='destinationList']//li//a[contains(text(),'*')]".replace("*", city));
    }

    public By getLblSelectorCityDestination(){
        return lblSelectorCityDestination;
    }
    public WebElementFacade getStrDestination(){
        return strDestination;
    }

    public static void setBtnSelectDay(String month, String day) {
        btnDayDeparture = By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-month='*']//a[@class='ui-state-default' and contains(text(),'++')]".replace("*", month).replace("++", day));
    }

    public static By getBtnSelectDay() {
        return btnDayDeparture;
    }

    public void setBtnSelectDayReturn(String newMonthReturn, String dayReturn) {
        btnDayReturn = By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-month='*']//a[@class='ui-state-default ui-state-active' and contains(text(),'++')]".replace("*", newMonthReturn).replace("++", dayReturn));
    }

    public static By getBtnSelectDayReturn() {
        return btnDayReturn;
    }

    public WebElementFacade getStrNumberAdults(){
        return strNumberAdults;
    }

    public void setNumberAdults(String strAdults) {
        listNumberAdults = By.xpath("//select[@id='adtSelectorDropdown']//option[@value='*']".replace("*", strAdults));
    }

    public static By getNumberAdults() {
        return listNumberAdults;
    }

    public void setStrNumberChildren(String strChildren) {
        listNumberChildren = By.xpath("//select[@id='AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD']//option[@value='*']".replace("*", strChildren));
    }

    public static By getNumberChildren() {
        return listNumberChildren;
    }
    public WebElementFacade getStrNumberChildren(){
        return strNumberChildren;
    }

    public WebElementFacade getBtnBuscarVuelos() {
        return btnBuscarVuelos;
    }

    public static By getlistOutboundFlight(){
        return listOutboundFlight;
    }

    public static By getlistReturnFlight(){
        return listReturnFlight;
    }

    public void setSelectTheTariff(String strTariffSelected) {
        listTariff = By.xpath("//label[@id='fareAcceptButtonId'][@for='*']".replace("*", strTariffSelected));
    }

    public static By getStrTariffSelected(){
        return listTariff;
    }


    public static By getLblMensaje() {
        return lblMensaje;
    }
}
