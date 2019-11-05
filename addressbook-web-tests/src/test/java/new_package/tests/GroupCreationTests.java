package new_package.tests;

import new_package.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Test1", "testik2", "Testik3"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before+1);
    app.logout();

  }

}
