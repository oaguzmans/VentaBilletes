package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RunnerTicketSales {


private static final Logger LOGGER = LoggerFactory.getLogger(RunnerTicketSales.class);

@Test
public void subRunner() {
        try {
        LOGGER.info("Medio");
        JUnitCore.runClasses(CRunnerTicketSales.class);
        }
        catch (Exception e) {
        LOGGER.error("Error Runner: RunnerTicketSales {}", e.getMessage());
        }
        }

@Before
public void test()  {
        try {
        LOGGER.info("Inicio test runner Login Failed");
            co.com.VentaBilletes.models.FeatureOverright.overrideFeatureFiles("src/test/resources");
        }
        catch(Exception e){
        LOGGER.error("Error Runner Login Failed: {}", e.getMessage());
        }
        }
    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(
            glue = {"co.com.VentaBilletes.definitions"},
            features = {"src/test/resources/features/VentaBilletes.feature"},
            tags = "@SearchAndSelectFlight"
    )
    public class CRunnerTicketSales {

    }


}
