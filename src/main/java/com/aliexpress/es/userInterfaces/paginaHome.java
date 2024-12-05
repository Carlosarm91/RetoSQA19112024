package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class paginaHome {
    public static final Target CAMPO_BUSQUEDA = Target.the("campo de busqueda").located(By.xpath("//input[@id='search-words']"));
    public static final Target BOTON_BUSQUEDA = Target.the("boton para buscar").located(By.xpath("//input[@type='button']"));
}
