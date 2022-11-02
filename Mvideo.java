import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mvideo {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String searchText = reader.readLine();
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.mvideo.ru/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='1']"));

        searchInput.click();

        searchInput.sendKeys(searchText);

        searchInput.sendKeys(Keys.ENTER);

         List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price__main-value']"));

         for (int i = 0; i < prices.size(); i++){
             WebElement price = prices.get(i);

             System.out.println(price.getText());
         }

         driver.close();
    }
}
