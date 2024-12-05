package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.aliexpress.es.userInterfaces.paginaResultadoBusqueda.PRIMER_RESULTADO;
import static com.aliexpress.es.userInterfaces.paginaResultadoBusqueda.PAIS_CHINA;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SeleccionarProductoYPais implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PAIS_CHINA, isPresent()).forNoMoreThan(10).seconds(),
                net.serenitybdd.screenplay.actions.Click.on(PAIS_CHINA),
                WaitUntil.the(PRIMER_RESULTADO, isPresent()).forNoMoreThan(10).seconds(),
                net.serenitybdd.screenplay.actions.Click.on(PRIMER_RESULTADO),
                Switch.toWindowTitled("Molten BG5000 hombres mujeres baloncesto tamaño 7 PU juego de entrenamiento pelotas estándar niños adultos juego de competición equipo oficial pelotas de baloncesto - AliExpress")
        );
    }
    public static SeleccionarProductoYPais seleccionar(){
        return Tasks.instrumented(SeleccionarProductoYPais.class);
    }
}
