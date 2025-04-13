package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "css-e3ac1k")
    WebElement l_element;

    @FindBy(xpath = "//input[@placeholder=\"example@gmail.com\"]")
    WebElement User_name;

    @FindBy(xpath = "//input[@placeholder=\"Enter Your Password\"]")
    WebElement User_pass;

    @FindBy(xpath = "//button[text()=\"Login\"]")
    WebElement btn;

    @FindBy(className = "css-126cz9e")
    WebElement dashboard;

    @FindBy(xpath = "(//div[@data-status=\"error\"])[1]")
    WebElement error;

    public boolean Elements(){
        return l_element.isDisplayed();
    }

    public void user_name(String name){
        User_name.sendKeys(name);
    }

    public void user_pass(String pass){
        User_pass.sendKeys(pass);
    }

    public void Button(){
        btn.click();
    }

    public boolean Dashboard(){
        return dashboard.isDisplayed();
    }

    public boolean Error(){
        return error.isDisplayed();
    }
}
