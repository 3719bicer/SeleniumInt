package Day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class R02 {
    public static void main(String[] args) {

        /*
         1- https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
         2- relativeLocators kullanarak NYC webelementini 3 farkli sekilde locate edin
        */

        // Toronto'in sagi, Portlan'in solu seklinde tarif edelim.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement Toronto= driver.findElement(By.id("pid2_thumb"));
        WebElement Portland= driver.findElement(By.id("pid4_thumb"));

        WebElement NYC = driver.findElement(RelativeLocator
                        .with(By.tagName("img"))
                        .toRightOf(Toronto)
                        .toLeftOf(Portland));

        System.out.println(NYC.getAttribute("id"));
    }
}
