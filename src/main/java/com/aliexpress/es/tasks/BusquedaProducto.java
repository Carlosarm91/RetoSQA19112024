package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.aliexpress.es.userInterfaces.paginaHome.CAMPO_BUSQUEDA;
import static com.aliexpress.es.userInterfaces.paginaHome.BOTON_BUSQUEDA;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class BusquedaProducto implements Task {

    private final String producto;

    public BusquedaProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPO_BUSQUEDA, isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(producto).into(CAMPO_BUSQUEDA),
                net.serenitybdd.screenplay.actions.Click.on(BOTON_BUSQUEDA)
        );
    }

    public static BusquedaProducto ingresarProducto(String producto){
        return Tasks.instrumented(BusquedaProducto.class, producto);
    }
}
