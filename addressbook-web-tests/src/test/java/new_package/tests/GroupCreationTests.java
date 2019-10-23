package new_package.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.fillGroupCreationForm();
    app.submitGrCrForm();
    app.returnToGroupPage();
    app.logout();
  }

}
