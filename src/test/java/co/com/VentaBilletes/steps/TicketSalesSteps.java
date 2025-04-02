package co.com.VentaBilletes.steps;

import co.com.VentaBilletes.pageObjects.TicketSalesPageObjects;
import org.openqa.selenium.By;
import utils.Utils;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TicketSalesSteps {

    String month = null;
    String day = null;

    TicketSalesPageObjects pageObjectsTikesSales;
    Utils utilsWeb;

    public void loginToVuelingWebsite(String strUrl) {

        try {
            pageObjectsTikesSales.openAt(strUrl);
            utilsWeb.esperaCargarPagina();
            utilsWeb.borrarcache();
            utilsWeb.tomarEvidencia();
        } catch (Exception e) {
            pageObjectsTikesSales.openAt(strUrl);
            utilsWeb.tomarEvidencia();
        }

    }
    public void AlertManagement() {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getBtnAcceptCookies());
        utilsWeb.tomarEvidencia();
        utilsWeb.clickBoton(pageObjectsTikesSales.getBtnAcceptCookies());
    }

    public void SelectTheRoundTripOption() {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getBtnIdaVuelta());
        utilsWeb.clickBoton(pageObjectsTikesSales.getBtnIdaVuelta());
    }

    public void FillOutTheForm(String strOrigin, String strDestination, String strNumberAdults, String strNumberChildren) {
        FillOrigin(strOrigin);
        FillDestination(strDestination);
        FillNumberAdults(strNumberAdults);
        FillNumberChildren(strNumberChildren);

        FirstLegDate();
        DateOfReturn();
    }

    public void FillOrigin(String strOrigin) {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getStrOrigin());
        utilsWeb.clickBoton(pageObjectsTikesSales.getStrOrigin());
        utilsWeb.seleccionarOpcion(pageObjectsTikesSales.getStrOrigin(), strOrigin);
        pageObjectsTikesSales.setLblSelectorCityOrigin(strOrigin);
        utilsWeb.clickBotonBy((By) pageObjectsTikesSales.getLblSelectorCityOrigin());
    }


    public void FillDestination(String strDestination) {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getStrDestination());
        utilsWeb.seleccionarOpcion(pageObjectsTikesSales.getStrDestination(), strDestination);
        pageObjectsTikesSales.setLblSelectorCityDestination(strDestination);
        utilsWeb.clickBotonBy((By) pageObjectsTikesSales.getLblSelectorCityDestination());
        utilsWeb.tomarEvidencia();
    }

    public void FirstLegDate() {
        Calendar c = new GregorianCalendar();
        month = Integer.toString(c.get(Calendar.MONTH));
        day = Integer.toString(c.get(Calendar.DATE));

        int newMonth = Integer.parseInt(month);
        int newDia = Integer.parseInt(day) + 4;

        month = Integer.toString(newMonth);
        day = Integer.toString(newDia);

        pageObjectsTikesSales.setBtnSelectDay(month, day);
        utilsWeb.bordearElementoBy(pageObjectsTikesSales.getBtnSelectDay());
        utilsWeb.clickBotonBy(pageObjectsTikesSales.getBtnSelectDay());

    }

    public void DateOfReturn() {
        int monthReturn = Integer.parseInt(month);
        int dayReturn = Integer.parseInt(day);
        switch (dayReturn) {

            case 29:
                monthReturn = monthReturn + 1;
                dayReturn = '1';
                break;
            case 30:
                monthReturn = monthReturn + 1;
                dayReturn = '2';
                break;
            case 31:
                monthReturn = monthReturn + 1;
                dayReturn = '3';
                break;
            default:
                dayReturn = dayReturn +3;
        }
        String newMonthReturn =  Integer.toString(monthReturn);
        String newDayReturn = Integer.toString(dayReturn);
        pageObjectsTikesSales.setBtnSelectDayReturn(newMonthReturn, newDayReturn);
        utilsWeb.bordearElementoBy(pageObjectsTikesSales.getBtnSelectDayReturn());
        utilsWeb.clickBotonBy(pageObjectsTikesSales.getBtnSelectDayReturn());
        utilsWeb.tomarEvidencia();
    }

    public void FillNumberAdults(String strAdults) {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getStrNumberAdults());
        utilsWeb.clickBoton(pageObjectsTikesSales.getStrNumberAdults());
        pageObjectsTikesSales.setNumberAdults(strAdults);
        utilsWeb.clickBotonBy(pageObjectsTikesSales.getNumberAdults());
    }


    public void FillNumberChildren(String strChildren) {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getStrNumberChildren());
        utilsWeb.clickBoton(pageObjectsTikesSales.getStrNumberChildren());
        pageObjectsTikesSales.setStrNumberChildren(strChildren);
        utilsWeb.clickBotonBy(pageObjectsTikesSales.getNumberChildren());
        utilsWeb.clickBoton(pageObjectsTikesSales.getStrNumberChildren());
        utilsWeb.tomarEvidencia();
    }

    public void SearchForFlights() {
        utilsWeb.bordearElemento(pageObjectsTikesSales.getBtnBuscarVuelos());
        utilsWeb.tomarEvidencia();
        utilsWeb.clickBoton(pageObjectsTikesSales.getBtnBuscarVuelos());
    }

    public void SelectOutboundFlight() {
        utilsWeb.contarClickElementoLista(pageObjectsTikesSales.getlistOutboundFlight());
    }
    public void SelectReturnFlight() {
        utilsWeb.contarClickElementoLista(pageObjectsTikesSales.getlistReturnFlight());
    }

    public void SelectTheTariff(String strTariffSelected) {
        pageObjectsTikesSales.setSelectTheTariff(strTariffSelected);
        utilsWeb.clickBotonBy(pageObjectsTikesSales.getStrTariffSelected());
        utilsWeb.tomarEvidencia();
    }

    public void ValidateMessagePageWhoWillTravel() {
        utilsWeb.posicionarElementoScroll(pageObjectsTikesSales.getLblMensaje());
        String strMensaje = utilsWeb.extraerTextodeLabel(pageObjectsTikesSales.getLblMensaje());
        assertThat("Introduce los datos tal y como figuran en el documento de identidad.", containsString(strMensaje));
        utilsWeb.tomarEvidencia();
    }
}