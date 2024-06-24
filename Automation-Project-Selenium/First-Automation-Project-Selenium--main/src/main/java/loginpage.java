import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
WebDriver driver;
    public loginpage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(id = "username")
WebElement usernamefp;
    public WebElement usernamePOM()
    {
        WebElement username=driver.findElement(By.id("username"));
        return username;
    }
    public WebElement passwordPOM()
    {
        WebElement password=driver.findElement(By.id("password"));
        return password;
    }
    public By flashPOM()
    {
        By flash=By.id("flash");
        return flash;
    }
    public By logoutPOM()
    {
        By logout =By.cssSelector("a[href=\"/logout\"]");
        return logout;
    }
    public void loginsteps(String username,String password)
    {
        usernamePOM().clear();
        usernamePOM().sendKeys(username);
        passwordPOM().sendKeys(password);
        passwordPOM().sendKeys(Keys.ENTER);

    }
}
