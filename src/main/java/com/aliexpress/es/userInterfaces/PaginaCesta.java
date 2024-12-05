package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCesta {
    public static Target TOTAL_ESTIMADO(int cantidad) {
        return Target.the("Label donde esta el total productos").located(By.xpath("((//div[@class='es--wrap--2p8eS4Q notranslate'])[2]//span[@class='es--char--1Qcd3D7'])[" + cantidad + "]"));
    }
}
