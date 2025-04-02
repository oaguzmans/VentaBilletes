package utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.List;


public class Utils extends PageObject{

	
	private static final Logger LOGGER = LoggerFactory.getLogger("Registro");
	private EnvironmentVariables environmentVariables; 
	private static final String WEBDRIVERTIMEOUT = "webdriver.timeouts.implicitlywait";

	private Logger logger = LoggerFactory.getLogger(Utils.class);

	public void borrarcache() {
		getDriver().manage().deleteAllCookies();
		
	}
	
	public void esperaCargarPagina() {		
		int intTimer = 15;
		try {
			new WebDriverWait(getDriver(), intTimer).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
					.executeScript("return document.readyState").equals("complete"));			
		}catch (Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo esperaCargarPagina " + e);
			}		
	}
	
	public void escribirTexto(WebElement webElement, String strTexto) {
		try {
			//WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			WebElementFacade input = element(webElement);
			waitFor(input).isEnabled();
			input.clear();
			input.type(strTexto);
		}catch (Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo escribirTexto" + e);
		}
	}

	public void tomarEvidencia() {
		try {
			Serenity.takeScreenshot();
		}catch(Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo tomarEvidencia " + e);
		}
	}
	
	public int obtenerTiempoSerenity() {
		return (Integer.parseInt(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERTIMEOUT)))/1000;
	}
	
	public void bordearElemento(WebElement txtProductoASeleccionar) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed green'",
					element(txtProductoASeleccionar));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#8fcc9e'", element(txtProductoASeleccionar)); 
		}catch(Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo bordearElemento " + e);
		}
	}

	public void bordearElementoBy(org.openqa.selenium.By txtProductoASeleccionar) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed green'",
					element(txtProductoASeleccionar));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#8fcc9e'", element(txtProductoASeleccionar));
		}catch(Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo bordearElemento " + e);
		}
	}

	public void clickBoton(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 15);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();

	} catch (Exception e) {
		System.out.println(webElement + " error: " + e.getMessage());
		LOGGER.error("ERROR: en la clase Utilidades en el método clickEnBoton: " + e);
	}
		
	}

	public void clickBotonBy(org.openqa.selenium.By btnSelectDay) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			element(btnSelectDay).click();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo clickBoton " + e);
		}
	}

	public void seleccionarOpcion(WebElement webElement, String stgOpcion) {
		try {
			WebElementFacade dropbox = element(webElement);
			dropbox.selectByVisibleText(stgOpcion);
		} catch (Exception e) {
			LOGGER.error("en la clase Utilidades en el metodo seleccionarOpcion" + e);
		}
	}

	public void contarClickElementoLista(By xpath) {
		try {
			List<WebElement> elemetos = getDriver().findElements(xpath);
			int tam = elemetos.size();
			SecureRandom random = new SecureRandom();
			Integer dato = random.nextInt(tam);
			elemetos.get(dato).click();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo contarClickElementoLista " + e);

		}
	}

	public void posicionarElementoScroll(By element) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);",
					element(element));
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo posicionarElementoScroll " + e);
		}
	}

	public String extraerTextodeLabel(By element) {
		try {
			if (element(element).isCurrentlyVisible() && element(element).isCurrentlyEnabled()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return element(element).getText().toString();
			}
			return "";
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo extraerTextodeLabel " + e);

		}
		return null;
	}


}
