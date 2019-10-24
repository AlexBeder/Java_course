package new_package.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupCreationForm();
    app.getGroupHelper().submitGrCrForm();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }

}
