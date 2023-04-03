package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.configuration.WebDriverConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePageUI.BTN_BUSCAR;
import static userinterfaces.HomePageUI.INPUT_BUSQUEDA;

public class BusquedaTk implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaTk.class);

    private final String pais;
    private final String correo;
    private final String tema;


    public BusquedaTk(String pais, String correo, String tema) {
        this.pais = pais;
        this.correo = correo;
        this.tema = tema;
    }

    public static BusquedaTk realizarBusqueda(String pais, String correo, String tema) {
        return instrumented(BusquedaTk.class, pais, correo, tema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(correo).into(INPUT_BUSQUEDA),
                Enter.theValue(tema).into(INPUT_BUSQUEDA),
                Enter.theValue(pais).into(INPUT_BUSQUEDA),
                Click.on(BTN_BUSCAR)
        );

        LOGGER.info("El usuario ingresa como criterio de busqueda: {}. Pero lo borra.", correo);
        LOGGER.info("Despues El usuario ingresa como criterio de busqueda: {}. Pero tambien lo borra", tema);
        LOGGER.info("Finalmente El usuario ingresa como criterio de busqueda: {}. Presiona click en boton buscar.", pais);
    }
}
