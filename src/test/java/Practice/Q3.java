package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {

    public static void main(String[] args) throws InterruptedException {

        /* ...Exercise3...
        1- go to url : https://www.techlistic.com/p/selenium-practice-form.html
        2- fill the firstname
        3- fill the lastname
        4- check the gender
        5- check the experience
        6- fill the date
        7- choose your profession -> Automation Tester
        8- choose your tool -> Selenium Webdriver
        9- choose your continent -> Europa
        10-choose your command  -> Browser Commands
        11-click submit button
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().deleteAllCookies();

        //driver.findElement(By.xpath("//button[@id='ez-accept-all']"));
        //Çıkan pencereyi açmak için

        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys( "Nevzat" + Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Celik" + Keys.ENTER);
        Thread.sleep(3000);

        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@id='sex-0']"));//Gender
        genderRadioButton.click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//input[@id='exp-1']")).click();
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);

    //NOT : (//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;')[7];
    //      xpath i style ile alırken ()[7] yapılabilir ancak efektif bir kullanım değildir.

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("21.04.2022" + Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@class='input-xlarge']")).sendKeys("Europe" + Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@id='selenium_commands']")).sendKeys("Browser Commands" + Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(3000);

        driver.close();
    }
}
