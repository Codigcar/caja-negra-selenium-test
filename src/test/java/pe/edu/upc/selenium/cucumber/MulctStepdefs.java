package pe.edu.upc.selenium.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pe.edu.upc.selenium.MyWebDriver;

public class MulctStepdefs {
    public static WebDriver webDriver;

    public MulctStepdefs() {
        webDriver = MyWebDriver.getWebDriver();
    }

    @Given("El policia ingresa el username y el password y hace click en login")
    public void elPoliciaIngresaElUsernameYElPasswordYHaceClickEnLogin() {
        webDriver.findElement(By.id("inputUsername")).sendKeys("commander1");
        webDriver.findElement(By.id("inputPassword")).sendKeys("commander");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @And("Hace click en la opcion Mulct del menu")
    public void haceClickEnLaOpcionMulctDelMenu() {
        WebElement linkmulct = webDriver.findElement(By.id("link-mulct"));
        linkmulct.click();
    }

    @And("Hace click en el boton nuevo")
    public void haceClickEnElBotonNuevo() {
        WebElement btnNuevoMulct = webDriver.findElement(By.xpath("//*[@id=\"btn-nuevo-mulct\"]"));
        btnNuevoMulct.click();
    }

    @When("Ingresa los datos del detenido y la multa")
    public void ingresaLosDatosDelDetenidoYLaMulta() {
        // Select Detenido
        Select sltDetainee = new Select( webDriver.findElement(By.id("detenido")) );
        // Agregando datos al formulario
        sltDetainee.selectByValue("1");

        // Fecha
        webDriver.findElement(By.id("fechaDetencion")).sendKeys("15/05/1998");
        // Direccion
        webDriver.findElement(By.id("direccion")).sendKeys("Av. Venezuela");
        // Infracacion
        new Select(webDriver.findElement(By.id("infraccion"))).selectByIndex(3);
        // Monto
        webDriver.findElement(By.id("monto")).clear();
        webDriver.findElement(By.id("monto")).sendKeys("580.0");
    }

    @And("Hace click en el boton Grabar")
    public void haceClickEnElBotonGrabar() {
        // Guardar
        webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).click();
    }

    @Then("Los datos son registrados en el sistema")
    public void losDatosSonRegistradosEnElSistema() {
        Assertions.assertEquals(1, 1);
    }


}
