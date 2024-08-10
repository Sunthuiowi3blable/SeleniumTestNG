package BT5BT6BT7BT8.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//CommonPage là để lưu những Element không thuộc về bất kỳ trang nào cả
public class CommonPage {

    //Khai báo driver cục bộ (chỉ sử dụng trong class)
    private WebDriver driver;

    //Khai báo hàm xây dựng
    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    //Khai báo các element trên trang dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");
    private By menuInHouseProducts = By.xpath("//span[normalize-space()='In House Products']");

    //**Các hàm xử lý**

    //LIÊN KẾT TRANG: sau khi hàm clickMenuDashboard xử lý xong nó sẽ chuyển đến trang DashboardPage
    public DashboardPage clickMenuDashboard(){
        WebUI.clickElement(menuDashboard);

        //Khởi tạo mới cho trang DashboardPage
        return new DashboardPage(driver);
    }

    public void clickMenuProducts(){
        WebUI.clickElement(menuProducts);
    }

    public AllProductsPage clickMenuAllProducts(){
        WebUI.clickElement(menuAllProducts);

        //Khởi tạo mới cho trang AllProductsPage
        return new AllProductsPage(driver);
    }

    public AllProductsPage clickMenuAllProductsWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuAllProducts);
        WebUI.clickElement(menuAllProducts);

        //Khởi tạo mới cho trang AllProductsPage
        return new AllProductsPage(driver);
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuCategory xử lý xong nó sẽ chuyển đến trang CategoryPage
    public CategoryPage clickMenuCategoryWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuCategory);
        WebUI.clickElement(menuCategory);

        //Khởi tạo mới cho trang CategoryPage
        return new CategoryPage(driver);
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuAddNewProductWithMenuProducts xử lý xong nó sẽ chuyển đến trang AddNewProductPage
    public AddNewProductPage clickMenuAddNewProductWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuAddNewProduct);
        WebUI.clickElement(menuAddNewProduct);

        //Khởi tạo mới cho trang AddNewProductPage
        return new AddNewProductPage(driver);
    }

    public InHouseProductsPage clickMenuInHouseProductsWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuInHouseProducts);
        WebUI.clickElement(menuInHouseProducts);

        //Khởi tạo mới cho trang InHouseProductsPage
        return new InHouseProductsPage(driver);
    }

}
