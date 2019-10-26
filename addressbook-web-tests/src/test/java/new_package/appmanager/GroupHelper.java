package new_package.appmanager;

        import new_package.model.GroupData;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);

  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGrCrForm() {
    click(By.name("submit"));
  }

  public void fillGroupForm() {
    GroupData GroupParam = new GroupData("Test1", "Test2", "Test3");
    type(By.name("group_name"), GroupParam.GroupName);
    type(By.name("group_header"), GroupParam.GroupHeader);
    type(By.name("group_footer"), GroupParam.GroupFooter);

  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void clickDeleteButton() {
    click(By.xpath("(//input[@name='delete'])[2]"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
click(By.name("update"));
  }
}