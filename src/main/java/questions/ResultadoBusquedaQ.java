package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultadoBusquedaQ implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultadoBusquedaQ.class);

    public ResultadoBusquedaQ(boolean b) {
    }

    public static Question<Boolean> resultado(boolean b) {
        return new ResultadoBusquedaQ(b);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;
        String  resBusqueda = TheWebPage.title().answeredBy(actor);

        if(resBusqueda.contains("Colombia")){
            resultado = true;
            LOGGER.info("Los resultados de busqueda fueron exitosos!");
        }else{
            LOGGER.error("La busqueda fue fallida");
        }
        return resultado;
    }
}
