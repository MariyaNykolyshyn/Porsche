package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PorscheTest {
    public static void main (String[]args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver_70v");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.porsche.com/usa/modaelstart/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        ((ChromeDriver) driver).findElementByXPath("//div[@data-range-name='718']//a[@class='m-107-info__link gui-btn gui-btn-transparent-with-outline gui-link-with-arrow']/span[contains(text(),'All Models')]").click();

        String price = driver.findElement(By.xpath("//div[@href='/usa/models/718/718-cayman-models/718-cayman/']//div[@class='m-14-model-price']")).getText();
        System.out.println(price);




    }

}
