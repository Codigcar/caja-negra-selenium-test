package pe.edu.upc.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class WebElemets {

    static WebDriver webDriver;

    public static void main(String[] args) {

        // Variables
        String urlPage = "http://localhost:8081/onewebs/login";

        // Establece el chrome driver
        WebDriver webDriver;
        String pathDriver = "C:\\Users\\carlo\\IdeaProjects\\selenium-sem10\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathDriver);

        webDriver = new ChromeDriver();

        //gestionar la ventana - Maximiza la ventana
        webDriver.manage().window().maximize();

        // Carga la pagina
        webDriver.get(urlPage);


        try {
            // login
            webDriver.findElement(By.id("inputUsername")).sendKeys("commander1");
            webDriver.findElement(By.id("inputPassword")).sendKeys("commander");
            webDriver.findElement(By.xpath("/html/body/div/form/button")).click();

            // link multa
         /*   WebElement linkmulct = webDriver.findElement(By.id("link-mulct"));
            linkmulct.click();*/

            webDriver.get("http://localhost:8081/onewebs/mulcts");

            // boton Nuevo
            WebElement btnNuevoMulct = webDriver.findElement(By.xpath("//*[@id=\"btn-nuevo-mulct\"]"));
            btnNuevoMulct.click();


            // -------------------------------------- LLenando formulario --------------------------------------
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
            // Guardar
            webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).click();

        } catch ( NoSuchElementException ne){
            System.err.println("ERROR NE: No hay el elemento que estas buscando\n" + ne.getMessage());
        } catch ( WebDriverException we ){
            System.err.println("ERROR: "+ we.getMessage());
        } catch ( Exception e){
            System.err.println("ERROR: "+ e.getMessage());
        } finally {
           // webDriver.close();
        }

    }
}
