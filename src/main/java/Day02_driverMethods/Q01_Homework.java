package Day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_Homework {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Yeni bir class olusturalim (Homework)
        2. ChromeDriver kullanarak, facebook sayfasina gidin
           ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
           degilse dogru basligi yazdirin.
        3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
           icermiyorsa “actual” URL’i yazdirin.
        4. https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7. Sayfayi yenileyin
        8. Sayfayi tam sayfa (maximize) yapin
        9. Browser’i kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectedTitle = "facebook";
        String actualTitle=driver.getTitle();

        String expectedUrl = "facebook";
        String actualUrl=driver.getCurrentUrl();

        //2-TITLE test
        if(actualTitle.contains(expectedTitle)){
            System.out.println("https://www.facebook.com sayfasının basligi :" +
                    expectedTitle + " kelimesini içermektedir.");
        }else {
            System.out.println("https://www.facebook.com sayfasının basligi :" +
                    expectedTitle + " kelimesini içermemektedir.");
        }

        //3-URL test
        if(actualUrl.contains(expectedUrl)){
            System.out.println("https://www.facebook.com URL'si : " +
                    expectedUrl + " kelimesini içermektedir.");
        }else {
            System.out.println("https://www.facebook.com URL'si : " +
                    expectedUrl + " kelimesini içermemektedir.");
        }
        //5-
        driver.navigate().to("https://www.walmart.com/");
        Thread.sleep(5000);

        String expectedWallmartTitle=  "Walmart.com";
        String actualWallmartTitle= driver.getTitle();

        if(actualWallmartTitle.contains(expectedWallmartTitle)){
            System.out.println("https://www.walmart.com/ sayfasının basligi : " +
                    expectedWallmartTitle + " kelimesini içermektedir.");
        }else {
            System.out.println("https://www.walmart.com/ sayfasının basligi : " +
                    expectedWallmartTitle + " kelimesini içermektedir.");
        }

        //6-
        driver.navigate().back();
        Thread.sleep(5000);

        //7-
        driver.navigate().refresh();
        Thread.sleep(5000);

        //8-
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.manage().window().maximize();
        Thread.sleep(5000);

      driver.quit();
    }
}
