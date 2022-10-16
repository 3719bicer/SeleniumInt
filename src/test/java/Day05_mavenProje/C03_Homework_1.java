package Day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.Socket;
import java.time.Duration;
import java.util.List;

public class C03_Homework_1 {

    @Test
    public void testHomeork1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-C01_TekrarTesti isimli bir class olusturun

        // 2- https://www.google.com/ adresine gidin.
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin
        WebElement cookiesButton;
        cookiesButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        cookiesButton.click();

        // 4-Sayfa basliginin “Google” ifadesi icerdigini test edin.
        WebElement googleTitle = driver.findElement(By.xpath("//*[text()='Google']"));
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (googleTitle.isEnabled()) {
            System.out.println("https://www.google.com/ adres title'ı : "
                    + actualTitle + " ifsesini ICERMEKTEDIR");
            System.out.println("Test PASSED");
        } else {
            System.out.println("https://www.google.com/ adres title'ı : "
                    + actualTitle + " ifsesini ICERMEMEKTEDIR");
            System.out.println("Test FAILED");
        }

        // 5- Arama cubuguna “Nutella” yazip aratin.
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(3000);

        // 6-Bulunan sonuc sayisini yazdirin.
        /*sonucSayisiStr=sonucSayisiStr.substring(
                ( sonucSayisiStr.indexOf("of")+3)  ,
                (sonucSayisiStr.indexOf("results")-1)

         1-16 of 230 results for "Samsung headphones"
        sonuc sayisi 100'den fazla test PASSED
        230*/

        WebElement nutellaSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(nutellaSonuc.getText());
        String nutellaSonucStr = nutellaSonuc.getText();
        nutellaSonucStr = nutellaSonucStr.substring((nutellaSonucStr.indexOf("Yaklaşık") + 8),
                (nutellaSonucStr.indexOf("sonuç") - 1));

        System.out.println("Sonus Sayısı : " + nutellaSonucStr);
        Thread.sleep(3000);

        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin.


        // 8-Sayfayi kapatin.
        driver.close();
    }
}
    /*
    // 1-C01_TekrarTesti isimli bir class olusturun

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin
        WebElement cookiesButton;
        cookiesButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        cookiesButton.click();

       // driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        //4-Sayfa basliginin "Google" ifadesi icerdigini test edin

        String Beklenenicerik = "Google";
        String CikanSonuc = driver.getTitle();

        if(CikanSonuc.contains(Beklenenicerik)) {
            System.out.println("Sayfa basliginin "Google" ifadesi iceriyor");
        } else {
            System.out.println("Sayfa basliginin "Google" ifadesi icerimiyor");
        }

        //5- Arama cubuguna "Nutella" yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);


        //6-Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuclar = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(bulunanSonuclar.getText());


        //7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin

        String[] bulunanElemanlar = bulunanSonuclar.getText().split(" ");
        long sayi = Long.parseLong(bulunanElemanlar[1].replaceAll("\\.", ""));

        if (sayi>10_000_000) {
            System.out.println("sonuc sayisinin 10 milyon'dan fazla");
        }else {
            System.out.println("sonuc sayisinin 10 milyon'dan fazla degil");
        }

        //8-Sayfayi kapatin
        driver.close();
            }
        }
     */


