package com.aliexpress.es.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src\\test\\resources\\features\\AgregarAlCarrito.feature",
        glue="com.aliexpress.es.stepDefinitions",
        tags="@Escenario_1",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AgregarAlCarritoRunner {
}
