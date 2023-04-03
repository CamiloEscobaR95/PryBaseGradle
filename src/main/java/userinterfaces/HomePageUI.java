package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url")
public class HomePageUI extends PageObject {
    public static final Target INPUT_BUSQUEDA = Target.the("Caja de busqueda").locatedBy("//input[@name='q']");
    public static final Target BTN_BUSCAR = Target.the("boton de busqueda").locatedBy("(//input[@name='btnK'])[1]");
}
