package com.aliexpress.es.stepDefinitions;

import com.aliexpress.es.questions.ObtenerTotalEstimado;
import com.aliexpress.es.questions.ObtenerValorCompraCesta;
import com.aliexpress.es.tasks.AgregarAlCarrito;
import com.aliexpress.es.tasks.BusquedaProducto;
import com.aliexpress.es.tasks.IrALaCesta;
import com.aliexpress.es.tasks.SeleccionarProductoYPais;
import com.aliexpress.es.utils.LeerExcel;
import io.cucumber.java.After;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.hamcrest.Matchers;

import java.io.IOException;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AgregarAlCarritoStepDefinitions {

    public Actor usuario = Actor.named("tester");
    List<List<String>> data;
    private String valorCompra;
    private String valorTotal;

    @Before
    public void setup(){
        usuario.can(BrowseTheWeb.with(getDriver()));
        LeerExcel excelReader = new LeerExcel();
        try {
            data = excelReader.readExcelFile("C:\\Users\\sarmi\\eclipse-workspace\\RetoSQA_19112024\\data.xlsx");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo Excel: " + e.getMessage());
        }
    }

    @Dado("que estoy en la pagina de inicio de aliexpress")
    public void queEstoyEnLaPaginaDeInicioDeAliexpress() {
        usuario.wasAbleTo(Open.url("https://es.aliexpress.com/"));
    }
    @Dado("busco un producto")
    public void buscoUnProducto() {
        usuario.attemptsTo(
            BusquedaProducto.ingresarProducto(data.get(1).get(0))
        );
    }

    @Cuando("lo agrego al carro de compras")
    public void loAgregoAlCarroDeCompras() {
        usuario.attemptsTo(
            SeleccionarProductoYPais.seleccionar()
        );
    }
    @Cuando("selecciono las cantidades del producto")
    public void seleccionoLasCantidadesDelProducto() {
        usuario.attemptsTo(
                AgregarAlCarrito.producto((int) Double.parseDouble(data.get(1).get(1)))
        );
    }
    @Entonces("valido el producto agregado")
    public void validoElProductoAgregado() {
        valorCompra = usuario.asksFor(ObtenerValorCompraCesta.compra());
        usuario.attemptsTo(
                IrALaCesta.clic()
        );
        valorTotal = usuario.asksFor(ObtenerTotalEstimado.total());
    }

    @Entonces("el precio del producto")
    public void elPrecioDelProducto() {
        usuario.should(
                seeThat("El valor de la compra es igual al total estimado",
                        actor -> valorCompra,
                        Matchers.containsString(valorTotal)
                )
        );
    }

    @After
    public void finalizarAutomatizacion(){
        Serenity.getWebdriverManager().closeCurrentDrivers();
    }

}
