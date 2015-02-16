import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    private WebDriver driver;    

    public RegPage(WebDriver drv) {
        driver=drv;
    }
    
    public void WhoDoYouLike(String male) {
        driver.findElement(By.xpath("//div[@class='inter-slide f m'"
                + " and @id='slide-1']//div[@class='select-prefer']"
                + "//div[contains(.,'"+male+"')]")).click();
        
    }
    
    public void ChooseHairColor(String color) {
        driver.findElement(By.xpath("//div[@class='inter-slide f visible'"
                + " and @id='slide-2']//div[@class='select-prefer']"
                + "//div[contains(. , '"+color+"')]")).click();
    }
    
    public void ChooseEyeColor(String color) {
        driver.findElement(By.xpath("//div[@class='inter-slide f visible'"
            + " and @id='slide-3']//div[@class='select-prefer']"
            + "//div[contains(. , '"+color+"')]")).click();
    }
    
    public void ChooseFigure(String typeOfFigure) {
        driver.findElement(By.xpath("//div[@class='inter-slide f visible'"
                + " and @id='slide-4']//div[@class='select-prefer']"
                + "//div[contains(. , '"+typeOfFigure+"')]")).click();
    }
    
    public void SetName(String name) {
        WebElement fieldname=driver.findElement(By.xpath("//form[@id='form-signup-f']"
                + "//input[@id='form-signup-name']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(fieldname));        
        fieldname.clear();
        fieldname.sendKeys(name);
    }
    
    public void SetEmail (String email) {
        driver.findElement(By.xpath("//form[@id='form-signup-f']"
                + "//input[@id='form-signup-email']")).clear();
        driver.findElement(By.xpath("//form[@id='form-signup-f']"
                + "//input[@id='form-signup-email']")).sendKeys(email);
    }
    
    public void SetAge(String age) {
        Select list = new Select(driver.findElement(By.xpath("//form[@id='form-signup-f']//select[@id='field-age-select']")));
        list.selectByVisibleText(age);
    }
    
    public void ClickRegButton() {
        driver.findElement(By.xpath("//form[@id='form-signup-f']//button[@id='submit_sign_up']")).click();
    }
    
    public void Registrate(String name, String email, String age) {
        SetName(name);
        SetEmail(email);
        SetAge(age);
        ClickRegButton();        
    }     
}
