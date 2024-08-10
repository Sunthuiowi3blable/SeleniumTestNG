package BT4;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.util.List;

public class AddProduct extends BaseTest {

    @Test
    public void checkAddProduct(){

        driver.get("https://cms.anhtester.com/login");

        //Đăng nhập
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //**ADD CATEGORY**

        //Click Products
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Click Category
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        //Click Add New category
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        //Name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(BienToanCuc.CATEGORY_NAME);

        //Parent Category
        driver.findElement(By.xpath("//select[@name='parent_id']/following-sibling::button")).click();
        driver.findElement(By.xpath("//div[@id='bs-select-1']/preceding-sibling::div[1]/input[1]")).sendKeys("sunthuiowi03");

        //Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("2");

        //Type
        driver.findElement(By.xpath("//div[@id='bs-select-2']/parent::div/preceding-sibling::button[1]")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-2-0']")).click();

        //Banner (200x200)
        driver.findElement(By.xpath("(//div[normalize-space()='Browse'])[2]")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Cosy");
        sleep(2);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        //Icon (32x32)
        driver.findElement(By.xpath("(//div[normalize-space()='Browse'])[4]")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("AK47");
        sleep(2);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        //Meta Title
        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("SẢN PHẨM CHẤT LƯỢNG HÀNG ĐẦU");

        //Meta description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Sản phẩm đạt chuẩn");

        //Filtering Attributes
        driver.findElement(By.xpath("//select[@name='filtering_attributes[]']/following-sibling::button")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-3-1']")).click();

        //Save
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        sleep(2);

        //**ADD NEW PRODUCT**

        //Click Add New Product
        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();

        //** Nhập thông tin vào trang Add New Product **
        //Product Name
        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(BienToanCuc.PRODUCT_NAME);

        //Category*
        driver.findElement(By.xpath("//button[@data-id='category_id']")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='category_id']/following-sibling::div//input")).sendKeys(BienToanCuc.CATEGORY_NAME);
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='category_id']/following-sibling::div//input")).sendKeys(Keys.ENTER);

        //Brand
        driver.findElement(By.xpath("//button[@data-id='brand_id']")).click();
        sleep(2);
        driver.findElement(By.xpath("//button[@data-id='brand_id']/following-sibling::div//input")).sendKeys("qc test");
        sleep(2);
        driver.findElement(By.xpath("//button[@data-id='brand_id']/following-sibling::div//input")).sendKeys(Keys.ENTER);

        //Unit
        driver.findElement(By.xpath("//input[@name='unit']")).sendKeys("3");

        //Weight (In Kg)
        driver.findElement(By.xpath("//input[@name='weight']")).clear();
        driver.findElement(By.xpath("//input[@name='weight']")).sendKeys("21");

        //Minimum Purchase Qty
        driver.findElement(By.xpath("//input[@name='min_qty']")).sendKeys("sun");

        //Tags*
        driver.findElement(By.xpath("//input[@name='tags[]']/preceding-sibling::tags")).sendKeys("sunsun");

        //Gallery Images (600x600)
        driver.findElement(By.xpath("(//div[normalize-space()='Browse'])[2]")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Clade");
        sleep(2);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]/div")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);

        //Thumbnail Images (300x300)
        driver.findElement(By.xpath("(//div[normalize-space()='Browse'])[4]")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("gio-qua-2");
        sleep(2);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]/div")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);

        //Video Provider
        driver.findElement(By.xpath("//button[@data-id='video_provider']")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@id='bs-select-3']/ul[1]/li[1]")).click();

        //Video Link
        driver.findElement(By.xpath("//input[@name='video_link']")).sendKeys("sunthuiowi.com");

        //Colors
        driver.findElement(By.xpath("//input[@name='colors_active']/following-sibling::span")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='colors']")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@id='bs-select-4']/ul[1]/li[2]")).click();
        driver.findElement(By.xpath("//div[@id='bs-select-4']/ul[1]/li[5]")).click();
        driver.findElement(By.xpath("//div[@id='bs-select-4']/ul[1]/li[6]")).click();
        driver.findElement(By.xpath("//div[@id='bs-select-4']/ul[1]/li[8]")).click();
        driver.findElement(By.xpath("//div[@id='bs-select-4']/ul[1]/li[9]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='colors']")).click();

        //Attributes
        driver.findElement(By.xpath("//button[@data-id='choice_attributes']")).click();
        sleep(1);
        driver.findElement(By.xpath("//a[@id='bs-select-5-0']")).click();
        driver.findElement(By.xpath("//button[@data-id='choice_attributes']")).click();

        //Size
        driver.findElement(By.xpath("//select[@name='choice_options_1[]']/following-sibling::button")).click();
        sleep(1);
        driver.findElement(By.xpath("//a[@id='bs-select-10-0']")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-10-1']")).click();
        driver.findElement(By.xpath("//select[@name='choice_options_1[]']/following-sibling::button")).click();

        //Unit price*
        driver.findElement(By.xpath("//input[@name='unit_price']")).clear();
        driver.findElement(By.xpath("//input[@name='unit_price']")).sendKeys("3");

        //Discount Date Range
        driver.findElement(By.xpath("//input[@name='date_range']")).click();
        sleep(1);

        //**1
        driver.findElement(By.xpath("(//td[@data-title='r2c3'])[1]")).click();
        sleep(2);

        driver.findElement(By.xpath("(//select[@class='hourselect'])[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("(//option[@value='5'])[2]")).click();

        driver.findElement(By.xpath("(//select[@class='minuteselect'])[1]")).click();
        driver.findElement(By.xpath("(//option[@value='15'])[1]")).click();

        driver.findElement(By.xpath("(//select[@class='ampmselect'])[1]")).click();
        driver.findElement(By.xpath("(//option[@value='PM'])[1]")).click();

        //**2
        driver.findElement(By.xpath("(//td[@data-title='r3c4'])[2]")).click();
        sleep(2);

        driver.findElement(By.xpath("(//select[@class='hourselect'])[2]")).click();
        sleep(1);
        driver.findElement(By.xpath("(//option[@value='7'])[3]")).click();

        driver.findElement(By.xpath("(//select[@class='minuteselect'])[2]")).click();
        driver.findElement(By.xpath("(//option[@value='20'])[3]")).click();

        driver.findElement(By.xpath("(//select[@class='ampmselect'])[2]")).click();
        driver.findElement(By.xpath("(//option[@value='PM'])[2]")).click();

        //**Select
        driver.findElement(By.xpath("(//button[normalize-space()='Select'])[3]")).click();
        sleep(1);

        //Discount*
        driver.findElement(By.xpath("//input[@name='discount']")).clear();
        driver.findElement(By.xpath("//input[@name='discount']")).sendKeys("1");
        driver.findElement(By.xpath("(//button[@title='Flat'])[1]")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-6-1']")).click();
        sleep(2);

        //External link
        driver.findElement(By.xpath("//input[@name='external_link']")).sendKeys("sunthuiowi1.com");
        sleep(1);

        //External link button text
        driver.findElement(By.xpath("//input[@name='external_link_btn']")).sendKeys("button");
        sleep(3);

        //Meta Title
        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("Sản phẩm tốt");
        sleep(2);

        //Description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Chất lượng hoàn thiện");
        sleep(2);

        //Meta Image
        driver.findElement(By.xpath("//label[normalize-space()='Meta Image']/following-sibling::div/div[1]/div")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("gio-qua-2");
        sleep(1);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        //Quantity
        driver.findElement(By.xpath("//input[@name='low_stock_quantity']")).sendKeys("18");

        //Tax
        driver.findElement(By.xpath("//input[@name='tax[]']")).sendKeys("15");
        driver.findElement(By.xpath("//select[@name='tax_type[]']/following-sibling::button")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-9-1']")).click();

        //Save & Publish
        driver.findElement(By.xpath("//button[normalize-space()='Save & Publish']")).click();
        sleep(2);

        //**SAU KHI SAVE THÀNH CÔNG SẼ TỰ ĐỘNG CHUYỂN SANG TRANG All Products**

        //Tìm kiếm sản phẩm vừa add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(BienToanCuc.PRODUCT_NAME);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(7);

        //Click hiển thị chi tiết thông tin sản phẩm vừa tìm kiếm
        driver.findElement(By.xpath("(//tbody//a[@title='View'])[1]")).click();
        sleep(10);

        driver.findElement(By.xpath("//button[@data-parent='.website-popup']")).click();
        sleep(3);

        // Tìm tất cả các phần tử phù hợp với XPath đã cho và lưu vào danh sách listColors
        List<WebElement> listColors = driver.findElements(By.xpath("//input[@name='id']/following-sibling::div[2]//label"));

        // In ra số lượng phần tử trong danh sách listColors
        System.out.println(listColors.size());

        int expectedNumberOfElements = 5;
        Assert.assertEquals(listColors.size(), expectedNumberOfElements, "Số lượng hiển thị không đúng mong đợi!");

        for (int i = 0; i<listColors.size(); i++) {
            System.out.println(listColors.get(i));
        }
    }

    @Test
    public void testDetailProduct(){
        driver.get("https://cms.anhtester.com/product/gioquatetmh-12");
        sleep(3);
        driver.findElement(By.xpath("//button[@data-parent='.website-popup']")).click();
        sleep(3);

        // Tìm tất cả các phần tử phù hợp với XPath đã cho và lưu vào danh sách listColors
        List<WebElement> listColors = driver.findElements(By.xpath("//input[@name='id']/following-sibling::div[2]//label"));

        // In ra số lượng phần tử trong danh sách listColors
        System.out.println(listColors.size());

        int expectedNumberOfElements = 5;
        Assert.assertEquals(listColors.size(), expectedNumberOfElements, "Số lượng hiển thị không đúng mong đợi!");

        for (int i = 0; i<listColors.size(); i++){
            System.out.println(listColors.get(i));
        }
    }
}
