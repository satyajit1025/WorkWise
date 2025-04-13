package test_files;

import extentReport.report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.File_Preview;
import pages.File_Upload;
import pages.Login;

import java.time.Duration;

public class Preview_Test extends report {
    WebDriver driver;
    Login login;
    File_Upload fileUpload;
    File_Preview filePreview;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://file-sharing-application.netlify.app/login");
        login = new Login(driver);
        filePreview = new File_Preview(driver);
        fileUpload = new File_Upload(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        test = extent.createTest("Preview check");
    }

    @Test(priority = 1)
    public void Login(){
        login.user_name("satyajit1027@gmail.com");
        login.user_pass("rintu1025");
        login.Button();
    }

    @Test(priority = 2)
    public void Upload() throws InterruptedException {
        fileUpload.Upload("C:\\Users\\satya\\Downloads\\CI&CD.pdf");
        fileUpload.U_btn();
        fileUpload.Msg();
        Thread.sleep(2000);
        fileUpload.Profile();
        fileUpload.Files();
    }

    @Test(priority = 3)
    public void Preview() throws InterruptedException {
        Thread.sleep(3000);
        filePreview.View();
        Assert.assertTrue(filePreview.preview(),"File not visible");
        filePreview.Close();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
