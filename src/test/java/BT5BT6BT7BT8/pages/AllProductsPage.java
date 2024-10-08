package BT5BT6BT7BT8.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AllProductsPage extends CommonPage{

    //Khai báo driver
    private WebDriver driver;

    //Khai báo hàm xây dựng
    public AllProductsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver); //tương đương với WebUI webUI = new WebUI(driver) nhưng vì lấy luôn class WebUI chấm gọi nên viết như kia
    }

    //**Khai báo các element trên trang All Products đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    private By inputSearch = By.xpath("//input[@id='search']");
    private By itemNewProduct = By.xpath("(//td[normalize-space()='GIOQUAMH'])[1]");
    private By buttonEdit = By.xpath("(//tbody//a[@title='Edit'])[1]");

    // **Hàm xử lý cho trang All Products**
    public void verifySearchProduct(String productName){
        WebUI.setText(inputSearch, productName);
        WebUI.setKey(inputSearch, Keys.ENTER);

        WebUI.assertEquals(WebUI.getElementText(itemNewProduct), "GIOQUAMH", "FAIL!! The new product not match.");
        System.out.println("Text Product: " + WebUI.getElementText(itemNewProduct));
    }

    public void searchProduct(String productName){
        WebUI.setText(inputSearch, productName);
        WebUI.setKey(inputSearch, Keys.ENTER);
    }

    public InHouseProductsPage clickButtonEdit(){
        WebUI.clickElement(buttonEdit);

        //Khởi tạo mới cho trang InHouseProductsPage
        return new InHouseProductsPage(driver);
    }

}
