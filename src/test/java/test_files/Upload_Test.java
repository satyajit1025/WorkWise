package test_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.File_Upload;
import pages.Login;

import java.time.Duration;

public class Upload_Test {
    WebDriver driver;
    Login login;
    File_Upload fileUpload;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://file-sharing-application.netlify.app/login");
        login = new Login(driver);
        fileUpload = new File_Upload(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void UploadWithoutPass() throws InterruptedException {
        login.user_name("satyajit1027@gmail.com");
        login.user_pass("rintu1025");
        login.Button();
        fileUpload.Upload("C:\\Users\\satya\\Downloads\\CI&CD.pdf");
        fileUpload.U_btn();
        fileUpload.Msg();
        Thread.sleep(4000);
        fileUpload.Profile();
        fileUpload.Files();
        Assert.assertTrue(fileUpload.visible(),"File not uploaded");
    }

    @Test(priority = 2)
    public void UploadWithPass() throws InterruptedException {
        login.user_name("satyajit1027@gmail.com");
        login.user_pass("rintu1025");
        login.Button();
        fileUpload.Upload("C:\\Users\\satya\\Downloads\\CI&CD.pdf");
        fileUpload.u_check();
        fileUpload.f_pass("1234");
        fileUpload.U_btn();
        fileUpload.Msg();
        Thread.sleep(4000);
        fileUpload.Profile();
        fileUpload.Files();
        Assert.assertTrue(fileUpload.visible(),"File not uploaded");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
