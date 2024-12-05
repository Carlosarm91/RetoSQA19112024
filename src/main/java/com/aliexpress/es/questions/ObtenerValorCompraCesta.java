package com.aliexpress.es.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static com.aliexpress.es.userInterfaces.PaginaCompra.LABEL_COP;

public class ObtenerValorCompraCesta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(LABEL_COP, isPresent()).forNoMoreThan(10).seconds();
        return the(LABEL_COP).answeredBy(actor).getText();
    }

    public static Question<String> compra(){
        return new ObtenerValorCompraCesta();
    }
}
