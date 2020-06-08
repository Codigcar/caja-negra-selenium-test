package pe.edu.upc.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru {

    public String comprar() {
        // Variables
        String urlPage = "http://live.demoguru99.com/";

        // Establece el chrome driver
        WebDriver webDriver;
        String pathDriver = "C:\\Users\\carlo\\IdeaProjects\\selenium-sem10\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathDriver);

        webDriver = new ChromeDriver();
        webDriver.get(urlPage);

        String titulo = webDriver.getTitle();
        System.out.println(titulo);

        WebElement opcionTV = webDriver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
        opcionTV.click();

        WebElement addTV2 = webDriver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > button > span > span"));
        addTV2.click();

        WebElement opcionMobile = webDriver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
        opcionMobile.click();

        WebElement addMobile1 = webDriver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button > span > span"));
        addMobile1.click();

        WebElement grandTotal = webDriver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
        String total = grandTotal.getText();

        //System.out.println("El importe total es: "+ total);
        return total;
    }
}
