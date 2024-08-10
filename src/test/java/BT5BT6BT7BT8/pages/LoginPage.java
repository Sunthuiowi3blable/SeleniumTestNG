package BT5BT6BT7BT8.pages;

import constants.ConfigData;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends CommonPage {

    //Khai báo driver cục bộ (chỉ sử dụng trong Class)
    private WebDriver driver;

    //Phải có hàm xây dựng cho từng class Page
    public LoginPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver); //tương đương với WebUI webUI = new WebUI(driver) nhưng vì lấy luôn class WebUI chấm gọi nên viết như kia
    }

    //Khai báo các Element dạng đối tượng By (đối tượng By là đối tượng mới chỉ thieiét lâọ cấu trúc chứ chưa tìm kiếm)
    private By firstheaderPage = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
    private By secondheaderPage = By.xpath("//p[normalize-space()='Login to your account.']");

    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");

    private By checkboxRememberMe = By.xpath("//span[normalize-space()='Remember Me']");

    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    //** Khai báo các hàm xử lý thuộc trang Login **

    //Hàm nhập Email
    public void enterEmail(String email){
        WebUI.setText(inputEmail, email);
    }

    //Hàm nhập Password
    public void enterPassword(String password){
        WebUI.setText(inputPassword, password);
    }

    //Hàm click nút Remember Me
    public void clickCheckboxRememberMe(){
        WebUI.clickElement(checkboxRememberMe);
    }

    //Hàm click nút Login
    public void clickButtonLogin(){
        WebUI.clickElement(buttonLogin);
    }

    //LIÊN KẾT TRANG: Hàm thao tác đăng nhập, chuyển hướng từ trang login sang trang dashboard bằng cách thay void bằng trang DashboardPage (Chuyển sang trang nào thay bằng tên trang đó)
    public DashboardPage loginCMS(String email, String password) {
        //Liên kết trang cần test (để ở biến tĩnh (static) trang ConfigData)
        driver.get(ConfigData.URL);
        //Nhập email
        enterEmail(email);
        //Nhập password
        enterPassword(password);
        //Click Login
        clickButtonLogin();

        //Khởi tạo mới cho trang DashboardPage
        return new DashboardPage(driver);
    }

    //Hàm xử lý đăng nhập thành công
    public void verifyLoginSuccess(){
        //Chờ trang load xong
        WebUI.waitForPageLoaded(driver);

        //Hàm kiểm tra xem phần tử có hiển thị lên không
        Assert.assertTrue(driver.findElement(menuDashboard).isDisplayed(), "FAIL. Can not redirect to Dashboard page!");

        //Hàm kiểm tra xem phần tử hiển thị có đúng với mong đợi hay không
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin", "FAIL. The current url not match!");
    }

    //Hàm xử lý Email để trống
    public void verifyLoginFailWithEmail(String expectedAlert){
        //Chờ trang load xong
        WebUI.waitForPageLoaded(driver);

        //getAttribute("validationMessage"): Phương thức này lấy giá trị của thuộc tính validationMessage từ phần tử inputEmail. Thuộc tính validationMessage chứa thông báo xác thực do trình duyệt tự động cung cấp khi một trường nhập liệu không thỏa mãn các điều kiện xác thực HTML5 (như required, pattern, type, v.v.).)
        String validationMessage = driver.findElement(inputEmail).getAttribute("validationMessage");

        //Hàm kiểm tra phần tử có hiển thị đúng với mong đợi hay không
        Assert.assertEquals(validationMessage, expectedAlert, "FAIL. The content of error massage not match!");
    }

    //Hàm xử lý Password để trống
    public void verifyLoginFailWithPassword(String expectedAlert){
        //Chờ trang load xong
        WebUI.waitForPageLoaded(driver);

        //getAttribute("validationMessage"): Phương thức này lấy giá trị của thuộc tính validationMessage từ phần tử inputPassword. Thuộc tính validationMessage chứa thông báo xác thực do trình duyệt tự động cung cấp khi một trường nhập liệu không thỏa mãn các điều kiện xác thực HTML5 (như required, pattern, type, v.v.).)
        String validationMessage = driver.findElement(inputPassword).getAttribute("validationMessage");

        //Hàm kiểm tra phần tử có hiển thị đúng với mong đợi hay không
        Assert.assertEquals(validationMessage, expectedAlert, "FAIL. The content of error massage not match!");
    }

}
