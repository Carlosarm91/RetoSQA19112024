package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.aliexpress.es.userInterfaces.PaginaCompra.BOTON_IR_A_LA_CESTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class IrALaCesta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_IR_A_LA_CESTA, isPresent()).forNoMoreThan(10).seconds(),
                net.serenitybdd.screenplay.actions.Click.on(BOTON_IR_A_LA_CESTA)
        );
    }

    public static IrALaCesta clic(){
        return Tasks.instrumented(IrALaCesta.class);
    }
}
