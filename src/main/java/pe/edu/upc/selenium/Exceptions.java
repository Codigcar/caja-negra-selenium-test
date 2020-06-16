package pe.edu.upc.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptions {

    static WebDriver webDriver;

    public static void main(String[] args) {

        // Variables
        String urlPage = "https://www.google.com.pe/";

        // Establece el chrome driver
        WebDriver webDriver;
        String pathDriver = System.getProperty("user.dir")+ "\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathDriver);

        webDriver = new ChromeDriver();

        // Carga la pagina
        webDriver.get(urlPage);

        //gestionar la ventana - Maximiza la ventana
        webDriver.manage().window().maximize();

        try {
            WebElement inputText = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
            inputText.sendKeys("Selenium");

            webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();

            String text= webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[4]/div/div[2]/div/span")).getText();
            System.out.println(text);

        } catch ( NoSuchElementException ne){
            System.err.println("ERROR NE: No hay el elemento que estas buscando\n" + ne.getMessage());
        } catch ( WebDriverException we ){
            System.err.println("ERROR: "+ we.getMessage());
        } catch ( Exception e){
            System.err.println("ERROR: "+ e.getMessage());
        } finally {
            webDriver.close();
        }

    }
}
