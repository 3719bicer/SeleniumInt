package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    public static void main(String[] args) throws InterruptedException {

        /* ...Exercise4...
        1- Navigate to  https://testpages.herokuapp.com/styled/index.html
        2- Click on  Calculater under Micro Apps
        3- Type any number in the first input
        4- Type any number in the second input
        5- Click on Calculate
        6- Get the result
        7- Print the result
         */

        //text'ni alabilmek için önce WebElemnet oluşturmalıyız.

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(3000);

        //2- Click on  Calculater under Micro Apps
        WebElement calcultorButton =driver.findElement(By.xpath("//a[@href='calculator']"));
        calcultorButton.click();
        Thread.sleep(3000);

        WebElement simpleCalculatorYazısı =driver.findElement(By.xpath("//h1[text()='Simple Calculator']"));
        if (simpleCalculatorYazısı.isDisplayed()) System.out.println("Test PASSED");
        else System.out.println("Test FAILED");

        //3- Type any number in the first input.
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("50" + Keys.ENTER);
        Thread.sleep(3000);

        //4- Type any number in the second input.
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("30" + Keys.ENTER);
        Thread.sleep(3000);

        //5- Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
        Thread.sleep(3000);

        //6- Get the result
        WebElement answer=driver.findElement(By.xpath("//span[@id='answer']"));
        Thread.sleep(3000);

        //7- Print the result
        System.out.println("Islem Sonucu : " + answer.getText());
        Thread.sleep(3000);
        driver.close();

        /*
        2.YÖNTEM
        String answerElementi2 = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("Sonuc : " + answerElementi2);
         */


        /*
        3.YÖNTEM
        int answerElementi3 = Integer.parseInt((driver.findElement(By.xpath("//span[@id='answer']")).getText()));
        System.out.println("Sonuc : " + answerElementi3);
        */

    }
}
