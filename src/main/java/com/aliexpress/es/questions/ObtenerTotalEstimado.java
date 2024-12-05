package com.aliexpress.es.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.aliexpress.es.userInterfaces.PaginaCesta.TOTAL_ESTIMADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ObtenerTotalEstimado implements Question<String>{

    private static String total;

    @Override
    public String answeredBy(Actor actor) {
        for(int j=1; j <= 11; j++){
            WaitUntil.the(TOTAL_ESTIMADO(j), isPresent()).forNoMoreThan(10).seconds();
            total = total+the(TOTAL_ESTIMADO(j)).answeredBy(actor).getText();
        }
        return total;
    }

    public static Question<String> total(){
        return new ObtenerTotalEstimado();
    }
}
