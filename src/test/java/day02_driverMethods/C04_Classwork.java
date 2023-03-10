package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class C04_Classwork {
    public static void main(String[] args) {
       /* a.web sayfasına gidin. https://www.amazon.com/
        Search(ara) “city bike”
        Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", ENTER);
       WebElement aramaSonucYazi=driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucYazi.getText());
        // Arama sonuc sayisini konsola yazdiriniz
        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Arama Sonuc Yazisi = " + aramaSonucYazisi.get(0).getText());
        // Arama sonuc sayisini konsola yazdiriniz
        String[] sonucSayisi = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[2]);
        // Sonuc sayisini Lambda ile yazdiriniz
        Arrays.stream(aramaSonucYazisi.get(0).getText().split(" ")).limit(3).skip(2).forEach(System.out::println);
        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> ilkWE = driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();




        driver.close();

    }
}
