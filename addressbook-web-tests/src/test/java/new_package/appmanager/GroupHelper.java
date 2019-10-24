package new_package.appmanager;

import new_package.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd=wd;

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

  public void clickDeleteButton() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
