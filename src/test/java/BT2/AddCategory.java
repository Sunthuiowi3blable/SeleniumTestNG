package BT2;

import common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AddCategory extends BaseTest {

    @Test
    public void testCategory(){
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi03", Keys.ENTER);

        sleep(2);
        String name = driver.findElement(By.xpath("//td[normalize-space()='sunthuiowi03']")).getText();
        System.out.println("Text: " + name);
        sleep(2);

    }

}
