package new_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class GroupDeletionTests {
  private WebDriver wd;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    clickDeleteButton();
    return2GroupPage();
  }

  private void return2GroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void clickDeleteButton() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  private void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  private void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  private void login() {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

 }
