package Day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class R01 {
    public static void main(String[] args) throws InterruptedException {

      /*  System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin.
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        //WebElement addElementButonu= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        WebElement addElementButonu= driver.findElement(By.xpath("//button[text()='Add Element']"));
        Thread.sleep(3000);
        addElementButonu.click();

        //3- Delete butonu’nun gorunur oldugunu test edin.
        WebElement deleteButonu= driver.findElement(By.xpath("//button[text()='Delete']"));

        if(deleteButonu.isDisplayed()){
            System.out.println("deleteButonu görünüyor : " + "Test PASSED");
        }else{
            System.out.println("deleteButonu görünmüyor : " + "Test FAILED");
        }

        //4- Delete tusuna basin.
        deleteButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin.

        WebElement addRemoveYazisi = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if(addRemoveYazisi.isDisplayed()){
            System.out.println("addRemoveYazisi görünüyor : " + "Test PASSED");
        }else{
            System.out.println("addRemoveYazisi görünmüyor : " + "Test FAILED");
        }

        //driver.close();*/


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        //WebElement amazonLogo = driver.findElement(By.xpath("//span[@id='logo-ext']"));
        List<WebElement> amazonLogoList = driver.findElements(By.cssSelector(".nav-sprite.nav-logo-base"));
        WebElement amazon = amazonLogoList.get(1);
        System.out.println(amazon.getTagName());

        WebElement amazonLogoList2 = driver.findElement(By.cssSelector("(.nav-sprite.nav-logo-base)[0]"));
        System.out.println(amazonLogoList2.getTagName());
    }
}
