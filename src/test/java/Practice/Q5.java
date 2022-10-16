package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
    public static void main(String[] args) throws InterruptedException {

        // .......Exercise5......../slash
        /*
//        1- Navigate to website https://testpages.herokuapp.com/styled/index.html
//        2- Under the ORIGINAL CONTENTS
//        3- click on Alerts
//        4- print the URL
//        5- navigate back
//        6- print the URL
//        7- Click on Basic Ajax
//        8- print the URL
//        9- enter value 20 and ENTER
//        10-and then verify Submitted Values is displayed open page
//        11-close driver
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //2- Under the ORIGINAL CONTENTS
        //3- click on Alerts
        driver.findElement(By.xpath("//a[@id='alert']")).click();
        Thread.sleep(3000);

        //4- print the URL
        System.out.println("Alert URL'si : " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //5- navigate back
        driver.navigate().back();
        Thread.sleep(3000);

        //7- Click on Basic Ajax
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        Thread.sleep(3000);

        //8- print the URL.
        System.out.println("Basic Ajax URL'si : " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //9- enter value 20 and ENTER.
        driver.findElement(By.xpath("//input[@id='lteq30']")).sendKeys("20" + Keys.ENTER);
        Thread.sleep(3000);

        //10-and then verify Submitted Values is displayed open page
        //WebElement valueElementText= driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(3000);
        String expectedText="Submit value";
        String actualText = driver.findElement(By.xpath("//p[text()='Submitted Values']")).getText();

        if (expectedText.equals(actualText)) System.out.println("Value değeri görülmektedir." + "\nTest PASSED");
        else   System.out.println("Value değeri görülmemektedir." + "\nTest FAİLED");
        Thread.sleep(3000);

        //11-close driver
        driver.close();
    }
}
