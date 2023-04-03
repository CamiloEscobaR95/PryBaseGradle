package co.com.base.gradle.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questions.ResultadoBusquedaQ;
import tasks.BusquedaTk;
import userinterfaces.HomePageUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class BusquedaDefinitions {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaDefinitions.class);

    @Given("que el usuario ingresa a la homepage de google")
    public void queElUsuarioIngresaALaHomepageDeGoogle() {
        HomePageUI google = new HomePageUI();
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn(google)
        );
        LOGGER.info("el usuario ingresa a la homepage de google");
    }

    @When("realiza una busqueda {word} {word} {string} {int}")
    public void realizaUnaBusqueda(String pais, String correo, String tema, int anio) {
        theActorInTheSpotlight().wasAbleTo(
                BusquedaTk.realizarBusqueda(pais, correo, tema)
        );
    }

    @Then("deberia ver los resultados de la busqueda")
    public void deberiaVerLosResultadosDeLaBusqueda() {
        theActorInTheSpotlight().should(
                seeThat(ResultadoBusquedaQ.resultado(true), equalTo(true))
        );
    }

}
