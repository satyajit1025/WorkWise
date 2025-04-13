package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class File_Preview {
    WebDriver driver;
    public File_Preview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//button[@type=\"button\"])[4]")
    WebElement view_file;

    @FindBy(xpath = "//*[@role=\"dialog\"]")
    WebElement file;

    public void View(){
        view_file.click();
    }

    public boolean preview(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role=\"dialog\"]")));
        return file.isDisplayed();
    }

    public void Close(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Close\"]"))).click();
    }
}
