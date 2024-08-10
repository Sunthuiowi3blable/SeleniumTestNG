package BT5BT6BT7BT8.testcases;

import BT5BT6BT7BT8.pages.CategoryPage;
import BT5BT6BT7BT8.pages.DashboardPage;
import BT5BT6BT7BT8.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;

    @Test
    public void testAddNewCategory (){

        String CATEGORY_NAME = "sunthuiowi13";
        String PARENT_CATEGORY_NAME = "sunthuiowi04";

        loginPage = new LoginPage(driver);

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang categoryPage
        categoryPage = dashboardPage.clickMenuCategoryWithMenuProducts();

        categoryPage.clickButtonAddNewCategory();
        categoryPage.enterDataAddNewCategory(CATEGORY_NAME, PARENT_CATEGORY_NAME);
        categoryPage.checkCategoryInTableList(CATEGORY_NAME);
        categoryPage.checkCategoryDetail(CATEGORY_NAME, PARENT_CATEGORY_NAME);
    }
}
