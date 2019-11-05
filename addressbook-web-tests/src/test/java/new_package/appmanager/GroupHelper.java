package new_package.appmanager;

import new_package.model.GroupData;
import org.openqa.selenium.By;


public class GroupHelper extends HelperBase {

  public GroupHelper(ApplicationManager app) {
    super(app);

  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGrCrForm() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.GroupName);
    type(By.name("group_header"), groupData.GroupHeader);
    type(By.name("group_footer"), groupData.GroupFooter);

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

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGrCrForm();
    returnToGroupPage();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}