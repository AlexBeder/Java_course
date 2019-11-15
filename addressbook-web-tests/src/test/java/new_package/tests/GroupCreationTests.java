package new_package.tests;

import new_package.model.GroupData;
import new_package.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = app.group().all();

    GroupData group = new GroupData().withGroupName("Test11");
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

    //app.getSessionHelper().logout();

  }
}


//Assert.assertEquals(before, after);