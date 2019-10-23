package new_package;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    fillGroupCreationForm();
    submitGrCrForm();
    returnToGroupPage();
    logout();
  }

}
