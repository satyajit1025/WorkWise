package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
    WebDriver driver;
    public Signup(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()=\"Signup\"]")
    WebElement signup_btn;

    @FindBy(className = "css-e3ac1k")
    WebElement elements;

    @FindBy(xpath = "//input[@placeholder=\"Enter Your Full Name\"]")
    WebElement name;

    @FindBy(xpath = "//input[@placeholder=\"example@gmail.com\"]")
    WebElement mail;

    @FindBy(xpath = "//input[@placeholder=\"Enter Your Password\"]")
    WebElement pass;

    @FindBy(xpath = "(//button[@type=\"button\"])[2]")
    WebElement btn;

    @FindBy(xpath = "(//*[@data-status=\"warning\"])[1]")
    WebElement failed;

    @FindBy(xpath = "(//div[@data-status=\"success\"])[1]")
    WebElement success;

    public void signup_page(){
        signup_btn.click();
    }

    public boolean Elements(){
        return elements.isDisplayed();
    }

    public void Name(String u_name){
        name.sendKeys(u_name);
    }

    public void Mail(String u_mail){
        mail.sendKeys(u_mail);
    }

    public void Pass(String u_pass){
        pass.sendKeys(u_pass);
    }

    public void button(){
        btn.click();
    }

    public boolean msg(){
        return failed.isDisplayed();
    }

    public boolean s_msg(){
        return success.isDisplayed();
    }
}
