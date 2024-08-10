package BT3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert1 extends BaseTest {

    //Kiểm tra text dialog theo khẳng định mềm
    @Test (priority = 1)
    public void testTextDialogSoftAssert(){
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        //SoftAssert text Login
        String Login = driver.findElement(By.xpath("//button[normalize-space()='Login']")).getText();
        System.out.println(Login);
        softAssert.assertEquals(Login, "Login", "Nút Login không đúng text");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //SoftAssert text Products (tạo test failed: Products khác Product)
        String Products = driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText();
        System.out.println(Products);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        softAssert.assertEquals(Products, "Products", "Products không đúng text");

        sleep(2);
        //SoftAssert text Category
//        softAssert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Category']")).isDisplayed(), "Nút Category không hiển thị");
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText(), "Category", "Category không đúng text");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi", Keys.ENTER);
        sleep(2);

        //SoftAssert text Sunthuiowi3
        String name = driver.findElement(By.xpath("//tr/td[2]")).getText();
        System.out.println("Text: " + name);
        sleep(2);
        softAssert.assertEquals(name, "sunthuiowi03", "Thông tin nhập vào không đúng");
        softAssert.assertAll();
    }

    //Kiểm tra text dialog theo khẳng định cứng
    @Test (priority = 2)
    public void testTextDialogHardAssert(){
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        //HardAssert text Login
        org.testng.Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Login']")).getText(), "Login", "Nút Login không đúng text");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //HardAssert text Products
        org.testng.Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText(), "Products", "Products hiển thị không đúng text");
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        sleep(2);
        //HardAssert text Category (Tạo test faild: Category khác Categori)
        org.testng.Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText(), "Category", "Category bị lỗi text");
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunthuiowi", Keys.ENTER);

        sleep(2);
        String name = driver.findElement(By.xpath("//tr/td[2]")).getText();
        System.out.println("Text: " + name);
        sleep(2);

        //HardAssert text Sunthuiowi3
        org.testng.Assert.assertEquals(name, "sunthuiowi03", "Thông tin nhập vào không đúng");
    }

}
