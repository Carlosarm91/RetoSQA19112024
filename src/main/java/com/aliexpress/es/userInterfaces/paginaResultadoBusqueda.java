package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class paginaResultadoBusqueda {
    public static final Target PRIMER_RESULTADO = Target.the("primer resultado de la busqueda").located(By.xpath("(//div[@class='images--hover--1N5tJXp'])[1]"));
    public static final Target PAIS_CHINA = Target.the("radiobutton del pais china").located(By.xpath("//span[contains(text(),'China')]"));

}
