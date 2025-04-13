package test_files;

import extentReport.report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Login;
import java.time.Duration;

public class Login_Test extends report {
    WebDriver driver;
    Login login;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://file-sharing-application.netlify.app/login");
        login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void LoginWithValidData() {
        test = extent.createTest("Valid Login");
        SoftAssert ast = new SoftAssert();
        boolean ele = login.Elements();
        ast.assertTrue(ele,"Elements are not visible");
        login.user_name("satyajit1027@gmail.com");
        login.user_pass("rintu1025");
        login.Button();
        ast.assertTrue(login.Dashboard());
        ast.assertAll();
    }

    @Test(priority = 2)
    public void LoginWithInvalidData(){
        test = extent.createTest("Invalid Login");
        SoftAssert ast = new SoftAssert();
        boolean ele = login.Elements();
        ast.assertTrue(ele,"Elements are not visible");
        login.user_name("satyajit1027@gmail.com");
        login.user_pass("rintu102");
        login.Button();
        ast.assertTrue(login.Error());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ast.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
