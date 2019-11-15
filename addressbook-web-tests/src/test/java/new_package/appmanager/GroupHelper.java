package new_package.appmanager;

import new_package.model.GroupData;
import new_package.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    groupCache = null;
    returnToGroupPage();
  }
  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    clickDeleteButton();
    groupCache = null;
    returnToGroupPage();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
 }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withGroupName(name));
    }
    return groups;
  }

  private Groups groupCache = null;


  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }

    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withGroupName(name));
    }
    return new Groups(groupCache);
  }


}

//OLD code:
//  public void delete(int index) {
//    selectGroup(index);
//    clickDeleteButton();
//    returnToGroupPage();
//  }


//  public void selectGroup(int index) {
//    wd.findElements(By.name("selected[]")).get(index).click();
//  }