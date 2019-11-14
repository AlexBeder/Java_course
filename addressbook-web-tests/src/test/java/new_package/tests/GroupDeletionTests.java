package new_package.tests;

import new_package.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData().withGroupName("Test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
   }



}
