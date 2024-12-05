package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCompra {
    public static final Target BOTON_INCREMENTAR = Target.the("Boton para incrementar la cantidad de productos").located(By.xpath("//div[@class='comet-v2-input-number-btn comet-v2-input-number-btn-increase']"));
    public static final Target BOTON_AGREGAR_AL_CARRITO = Target.the("Boton para agregar al carrito").located(By.xpath("//button[@class='comet-v2-btn comet-v2-btn-primary comet-v2-btn-large add-to-cart--addtocart--Qhoji3M add-to-cart--hasBuyNow--QxW176q comet-v2-btn-important']"));
    public static final Target LABEL_COP = Target.the("Texto del valor de la compra").located(By.xpath("//div[@class='cart-summary-top']"));
    public static final Target BOTON_IR_A_LA_CESTA = Target.the("Boton Ir a la cesta").located(By.xpath("//a[@class='cart-summary-tocart']"));
}
