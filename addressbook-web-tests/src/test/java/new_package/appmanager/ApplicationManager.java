package new_package.appmanager;

import new_package.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.GroupsHelper;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends GroupHelper {
  private WebDriver wd;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
    login();
  }

  private void login() {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGrCrForm() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupCreationForm() {
    GroupData GroupParam = new GroupData("Test1", "Test2", "Test3");
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(GroupParam.GroupName);
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(GroupParam.GroupHeader);
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(GroupParam.GroupFooter);
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    wd.quit();
  }

  public void clickDeleteButton() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
