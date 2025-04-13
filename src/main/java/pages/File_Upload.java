package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class File_Upload {
    WebDriver driver;
    public File_Upload(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type=\"file\"]")
    WebElement upload;

    @FindBy(xpath = "//button[text()=\"Upload File\"]")
    WebElement upload_btn;

    @FindBy(xpath = "//span[@aria-hidden=\"true\"]")
    WebElement upload_check;

    @FindBy(xpath = "//input[@placeholder=\"Set Password\"]")
    WebElement file_pass;

    @FindBy(xpath = "(//button[@type=\"button\"])[1]")
    WebElement profile;

    @FindBy(xpath = "(//button[@type=\"button\"])[2]")
    WebElement all_files;

    @FindBy(className = "css-pcqdst")
    WebElement list;

    @FindBy(xpath = "//*[@class=\"css-1pq15d\"]")
    WebElement msg;

    public void Upload(String path){
        upload.sendKeys(path);
    }

    public void U_btn(){
        upload_btn.click();
    }

    public void u_check(){
        upload_check.click();
    }

    public void f_pass(String pass){
        file_pass.sendKeys(pass);
    }

    public void Profile(){
        profile.click();
    }

    public void Files(){
        all_files.click();
    }

    public boolean visible(){
        return list.isDisplayed();
    }

    public void Msg(){
        msg.click();
    }
}
