package BT3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.security.Key;

public class Assert2 extends BaseTest {

    @Test(priority = 1)
    public void Edit (){
        driver.get("https://cms.anhtester.com/login");

        //Đăng nhập
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Chọn Products
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        sleep(1);

        //Chọn Category
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        sleep(1);

        //Tìm kiếm sunthuiowi
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi", Keys.ENTER);

        sleep(3);

        //Nhấn Edit sunthuiowi3
        driver.findElement(By.xpath("(//tr[1]/td[10]/a[1])")).click();

        sleep(3);

        //Chỉnh sửa giá trị
        driver.findElement(By.xpath("//input[@id='order_level']")).clear();
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("22");
        sleep(2);
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("sun");
        sleep(2);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).clear();
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("sun");

        sleep(3);

        //Save
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        sleep(3);

        //Search lại giá trị sau khi edit
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi", Keys.ENTER);

        sleep(2);
    }

    @Test (priority = 2)
    public void Delete(){
        driver.get("https://cms.anhtester.com/login");

        //Đăng nhập
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Chọn Products
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        sleep(1);

        //Chọn Category
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        sleep(1);

        //Tìm kiếm sunthuiowi
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi", Keys.ENTER);

        sleep(3);

        //Nhấn nút Delete
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/a[2]")).click();
        driver.findElement(By.xpath("//a[@id='delete-link']")).click();

        sleep(3);

        //Search lại xem element đó có tồn tại hay không
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//input[@idz='search']")).sendKeys("sunthuiowi", Keys.ENTER);

        sleep(3);
    }
}
