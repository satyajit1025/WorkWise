package test_files;

import extentReport.report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Signup;

import java.time.LocalDateTime;


public class Signup_Test extends report {
    WebDriver driver;
    Signup signup;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://file-sharing-application.netlify.app/login");
        signup = new Signup(driver);
    }

    @Test(priority = 1)
    public void SignupWithValidData(){
        test = extent.createTest("Valid Signup");
        signup.signup_page();
        boolean elem = signup.Elements();
        Assert.assertTrue(elem,"Elements are not visible");
        signup.Name("Satyajit");
        signup.Mail("rint@gmail.com");
        signup.Pass("satya@123");
        signup.button();
    }

    @Test(priority = 2)
    public void SignUpWithDuplicateData() throws InterruptedException {
        test = extent.createTest("Duplicate Data Signup");
        signup.signup_page();
        boolean elem = signup.Elements();
        Assert.assertTrue(elem,"Elements are not visible");
        signup.Name("Satyajit");
        signup.Mail("satya596@gmail.com");
        signup.Pass("satya@123");
        signup.button();
        Thread.sleep(2000);
        if(signup.msg()){
            System.out.println("User is registered already");
        }else{
            System.out.println("Not registered");
        }
    }

    @Test(priority = 3)
    public void SignupWithInvalidData() throws InterruptedException {
        test = extent.createTest("Invalid Signup");
        signup.signup_page();
        boolean elem = signup.Elements();
        Assert.assertTrue(elem,"Elements are not visible");
        signup.Name("4565465");
        signup.Mail("satya78702@gmail.c");
        signup.Pass("12345612");
        signup.button();
        Thread.sleep(2000);
        if(signup.s_msg()){
            System.out.println("User registered successfully");
        }else{
            System.out.println("Invalid data");
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
