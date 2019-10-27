package new_package.tests;

import new_package.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Testik", "testik2", "Testik3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }
}
