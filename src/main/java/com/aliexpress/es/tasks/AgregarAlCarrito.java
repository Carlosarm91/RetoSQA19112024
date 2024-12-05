package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.aliexpress.es.userInterfaces.PaginaCompra.BOTON_INCREMENTAR;
import static com.aliexpress.es.userInterfaces.PaginaCompra.BOTON_AGREGAR_AL_CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AgregarAlCarrito implements Task {

    private final int cantidad;

    public AgregarAlCarrito(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int j=1; j < cantidad; j++){
            actor.attemptsTo(
                WaitUntil.the(BOTON_INCREMENTAR, isPresent()).forNoMoreThan(10).seconds(),
                net.serenitybdd.screenplay.actions.Click.on(BOTON_INCREMENTAR)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(BOTON_AGREGAR_AL_CARRITO, isPresent()).forNoMoreThan(10).seconds(),
                net.serenitybdd.screenplay.actions.Click.on(BOTON_AGREGAR_AL_CARRITO)
        );
    }

    public static AgregarAlCarrito producto(int cantidad){
        return Tasks.instrumented(AgregarAlCarrito.class, cantidad);
    }


}
