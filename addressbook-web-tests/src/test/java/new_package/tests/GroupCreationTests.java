package new_package.tests;

import new_package.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();

    GroupData group = new GroupData().withGroupName("Test11");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);

    //app.getSessionHelper().logout();

  }

}
