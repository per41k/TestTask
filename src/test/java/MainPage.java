
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    
    private WebDriver driver;
    public WebElement nickname;
    
    public MainPage(WebDriver drv) {
        driver=drv;
        this.nickname=driver.findElement(By.xpath("//a[@class='top-ava']"));
    }
    
    public String getName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(nickname));        
        return nickname.getText();
    }
    
}
