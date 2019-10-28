package new_package.tests;

import new_package.model.GroupData;
import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereARecord()){
      app.getGroupHelper().createGroup(new GroupData("Test1", "testik2", "Testik3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().clickDeleteButton();
    app.getGroupHelper().returnToGroupPage();
  }

}
