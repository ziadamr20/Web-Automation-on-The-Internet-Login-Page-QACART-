import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
WebDriver driver=null;
loginpage login=null;

  @BeforeTest
  public void OpenBrowser() throws InterruptedException {
      String chroampath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver",chroampath);
      driver= new ChromeDriver();
      login=new loginpage(driver);
      driver.navigate().to("https://the-internet.herokuapp.com/login");
      driver.manage().window().maximize();
      Thread.sleep(3000);

  }


  @Test
  public void ValidData()
  {
      login.loginsteps("tomsmith","SuperSecretPassword!");
      String expectedresult="You logged into a secure area!";
      String actualresult=driver.findElement(login.flashPOM()).getText();

      System.out.println("first assertion");
      Assert.assertTrue(actualresult.contains(expectedresult));

      System.out.println("second assertion");
      Assert.assertTrue(driver.findElement(login.logoutPOM()).isDisplayed());

      System.out.println("third assertion");
      Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

  }
  @Test
  public void InValidData()
  {
      login.loginsteps("tom","Super");

      System.out.println("first assertion");
      String expectedresult="Your username is invalid!";
      String actualresult=driver.findElement(login.flashPOM()).getText();
      Assert.assertTrue(actualresult.contains(expectedresult),"Error message : text is wrong");



  }
  @AfterTest
  public void CloseDriver()
  {
      driver.quit();
  }




}
