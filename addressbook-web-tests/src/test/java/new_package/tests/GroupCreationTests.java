package new_package.tests;

import new_package.model.GroupData;
import new_package.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupName("test 1").withGroupHeader("header 1").withGroupFooter("footer 1")});
    list.add(new Object[] {new GroupData().withGroupName("test 2").withGroupHeader("header 2").withGroupFooter("footer 2")});
    list.add(new Object[] {new GroupData().withGroupName("test 3").withGroupHeader("header 3").withGroupFooter("footer 3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
      app.goTo().GroupPage();
      Groups before = app.group().all();
      app.group().create(group);
      Groups after = app.group().all();
      assertThat(app.group().count(), equalTo(before.size()+1));

      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
     //app.getSessionHelper().logout();

  }
  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = app.group().all();

    GroupData group = new GroupData().withGroupName("Test1'1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size()));

    assertThat(after, equalTo(before));
  }
}


//Assert.assertEquals(before, after);