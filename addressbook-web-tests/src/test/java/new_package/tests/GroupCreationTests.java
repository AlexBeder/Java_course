package new_package.tests;

import new_package.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Testik", "testik2", "Testik3"));
    app.getGroupHelper().submitGrCrForm();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }

}
