import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTask {
    private static String url="http://flirchi.com/sign/inter?fr=1&p=1232";
    private static WebDriver driver;
    private static RegPage rpage;
    private static MainPage mpage;
        
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\NetBeansProjects\\flirchi\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);        
    }
    
    @Test
    public void RegistrationTest() {
        rpage = new RegPage(driver);
        rpage.WhoDoYouLike("Девушки");
        rpage.ChooseHairColor("Темные");
        rpage.ChooseEyeColor("Светлые");
        rpage.ChooseFigure("Стройная");
        String name="Testname";
        String email="testilades@yndexj.ru";
        String age="24 года";
        rpage.Registrate(name, email, age);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mpage = new MainPage(driver);                        
        assertEquals(name, mpage.getName());
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
}
