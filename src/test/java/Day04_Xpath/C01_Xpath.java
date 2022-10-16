package Day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Su ana kadar ogrendiğimiz 6 adet locator HTML koduna baglıdır.
        Xpath ve cssSelector sadece bir attribute'e veya tag'e bagımlı olmadan
        her web elementi locate etmenize yarar.

        Her HTML element'de
        1- tag
        2- attreibute(s)
        3- attribute value

        xpath ve cssSelector bu 3 maddenin kombinasyonu ile olusur.
        //tagIsmi[@attributeIsmi='value']
         */

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        WebElement addButonu = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addButonu.click();
        Thread.sleep(5000);
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if(deleteButonu.isDisplayed()){
            System.out.println("DeleteButonu Görünme Tesiti : PASSED");
        }else {
            System.out.println("DeleteButonu Görünmemektedir.");
            System.out.println("DeleteButonu Görünme Tesiti : FAILED");
        }
        //4- Delete tusuna basin
        deleteButonu.click();
        Thread.sleep(5000);
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRomveYazıElementi = driver.findElement(By.xpath("//h3"));
                                        //driver.findElement(By.tagName("h3"));

        if(addRomveYazıElementi.isDisplayed()){
            System.out.println("Add/Remove Elements Butonu Görünmektedir. " +
                    "Test : PASSED");
        }else {
            System.out.println("Add/Remove Elements yazısı görünmemektedir.");
            System.out.println("DeleteButonu Görünme Tesiti : FAILED");
        }
        Thread.sleep(5000);
        driver.close();
    }
}
