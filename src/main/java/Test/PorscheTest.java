package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.annotation.W3CDomHandler;
import java.util.concurrent.TimeUnit;

public class PorscheTest {
    public static void main (String[]args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.porsche.com/usa/modaelstart/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement element = ((ChromeDriver) driver).findElementByXPath("//div[@data-range-name='718']//a[@class='m-107-info__link gui-btn gui-btn-transparent-with-outline gui-link-with-arrow']");
        //WebElement element = ((ChromeDriver) driver).findElementByXPath("//div[@data-range-name='718']//a[@class='m-107-info__link gui-btn gui-btn-transparent-with-outline']/span[contains(text(),'All Models')]");
        //WebDriverWait wait = new WebDriverWait(driver,5);       explicite type of wait
        // wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        String price1 = driver.findElement(By.xpath("//div[@href='/usa/models/718/718-cayman-models/718-cayman/']//div[@class='m-14-model-price']")).getText();
        System.out.println(price1);

        ((ChromeDriver) driver).findElementByXPath("//div[@href='/usa/models/718/718-cayman-models/718-cayman/']//div[@class='m-14-model-price']").click();
        String price2 = driver.findElement(By.xpath("//div[@class='m-104-techdata-item m-104-techdata-item--price']/div[@class ='m-104-techdata-item__value']")).getText();
        System.out.println(price2);

        if (price1.equals(price2)) {
            System.out.println("Correct match");
        } else
            System.out.println("Incorrect");


        JavascriptExecutor jk = (JavascriptExecutor) driver;
        jk.executeScript("window.scrollBy(0,400)");
        ((ChromeDriver) driver).findElementByXPath("//a[@class='m-104-techdata-links__gui-btn gui-btn gui-btn-blue gui-link-with-arrow']").click();

        driver.get("https://www.porsche.com/usa/modelstart/all/?modelrange=718#s718-cayman-models");
        ((ChromeDriver) driver).findElementByXPath("//div[@id='m982120' ]//div[@class='m-14-model-price']").click();


        String currentWindow = driver.getWindowHandle();
        boolean closeOldWindow = true;
        // switch to first window that is not equal to the current window
        String newWindow = null;
        for (final String handle : driver.getWindowHandles()) {
            if (!currentWindow.equals(handle)) {
                newWindow = handle;
                break;
            }
        }

        // if there's another window found...
        if (newWindow != null) {
            if (closeOldWindow) {
                // close the current window
                driver.close();
            }
            // ...switch to the new window
            driver.switchTo().window(newWindow);
        }
            //driver.switchTo().window("https://cc.porsche.com/icc/ccCall.do?rt=1562119917&screen=1536x864&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");
            // driver.get("https://www.porsche-code.com/PKMUFPB9");
            JavascriptExecutor jav = (JavascriptExecutor) driver;
            jav.executeScript("return document.readyState");


            String equipment = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
            equipment.equals("0");
            System.out.println(equipment);

            String total = driver.findElement(By.xpath("//div[@class = \"row highlighted priceTotal separator\"]//div[@class = \"cca-price\"]")).getText();
            System.out.println(total);

            ((ChromeDriver) driver).findElementByXPath("//div[@class ='row']/div[@class ='cca-label']/span[@class='expandButton']").click();


            String extra = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
            System.out.println(extra);

            int price = Integer.parseInt(price1);


            /* var sum = +price1  + (+extra); sum
            if (total == sum){
                System.out.println("Verified");
            }    */

        ((ChromeDriver) driver).findElementByXPath("//div[@id =\"11\"]//li[@id='s_exterieur_x_FJ5']").click();
        String mblue = driver.findElement(By.xpath("//div[@id ='s_exterieur_x_IAF']//div [@class ='content recommendContainer hideRecommendationFootnote']//div[@class='tt_price tt_cell']")).getText();
        System.out.println(mblue);

        String equipment2 = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
        System.out.println(equipment2);

        if (mblue == equipment2){
            System.out.println("Price for mblue verified");
        }

        String total2 = driver.findElement(By.xpath("//div[@class = \"row highlighted priceTotal\"]//div[@class = \"cca-price\"]")).getText();
        System.out.println(total2);

        /* var sum2 = +sum + +equipment2;
        if (total2 == sum2){
          System.out.println("Verified");
        }
         */

        JavascriptExecutor jm = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        ((ChromeDriver) driver).findElementByXPath("//li[@id='s_exterieur_x_M439']").click();
        String csWheels = driver.findElement(By.xpath("//li[@id='s_exterieur_x_M439']")).getText();
        System.out.println(csWheels);
        String equipment3 = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
        System.out.println(equipment3);


        /* var additional = +mblue + +csWheels;
        if (equipment3 == additional){
          System.out.println("Verified");
        }
         */

        String total3 = driver.findElement(By.xpath("//div[@class = \"row highlighted priceTotal\"]//div[@class = \"cca-price\"]")).getText();
        System.out.println(total3);
         /* var sum3 = +price + +equipment3 + +extra;
        if (total3 == sum3){
          System.out.println("Verified");
        }
         */

        JavascriptExecutor jp = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        ((ChromeDriver) driver).findElementByXPath("//div[@class = 'seat']//span[@id ='s_interieur_x_PP06']").click();

        String psSeats = driver.findElement(By.xpath("")).getText();
        System.out.println(psSeats);
        String equipment4 = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
        System.out.println(equipment4);
        /* var additional2 = +additional + +psSeats;
        if (equipment4 == additional2){
          System.out.println("Verified");
        }
         */
        String total4 = driver.findElement(By.xpath("//div[@class = \"row highlighted priceTotal\"]//div[@class = \"cca-price\"]")).getText();
        System.out.println(total4);
         /* var sum4 = +price + +equipment4 + +extra;
        if (total4 == sum4){
          System.out.println("Verified");
        }
         */

        JavascriptExecutor jr = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        ((ChromeDriver) driver).findElementByXPath("//div[@id ='IIC_subHdl']").click();
        ((ChromeDriver) driver).findElementByXPath("//div[@id ='vs_table_IIC_x_PEKH']").click();
        String interior = driver.findElement(By.xpath("//div[@id ='vs_table_IIC_x_PEKH']//div[@class='pBox']")).getText();
        System.out.println(interior);
        String equipment5 = driver.findElement(By.xpath("//div[@class='row']//div[@class='cca-price']")).getText();
        System.out.println(equipment5);
        /* var additional3 = +additional2 + +interior;
        if (equipment5 == additional3){
          System.out.println("Verified");
        }
         */
         /*
        String total6 = driver.findElement(By.xpath("//div[@class ="row highlighted priceTotal"]//div[@class ="cca-price"]")).getText();
        System.out.println(total6);
         /* var sum5 = +price + +equipment5 + +extra;
        if (total5 == sum5){
          System.out.println("Verified");
        }
         */
      //  JavascriptExecutor jb = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");  //???
        ((ChromeDriver) driver).findElementByXPath("//div[@id='IMG_subHdl']").click();
        ((ChromeDriver) driver).findElementByXPath("//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']").click();
        String speed = driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']//div[@class ='pBox']")).getText();
        System.out.println(speed);

       // JavascriptExecutor jb = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        ((ChromeDriver) driver).findElementByXPath("//div[@id='vs_table_IMG_x_M450_x_c84_M450_x_shorttext']").click();
        String brakes = driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']//div[@class ='pBox']")).getText();
        System.out.println(speed);





























    }
    }









