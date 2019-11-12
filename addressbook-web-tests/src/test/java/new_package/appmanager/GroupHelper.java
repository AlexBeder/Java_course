package new_package.appmanager;

import new_package.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGrCrForm();
    returnToGroupPage();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }
  public void delete(int index) {
    selectGroup(index);
    clickDeleteButton();
    returnToGroupPage();
  }
}