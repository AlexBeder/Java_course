package new_package.tests;

import new_package.model.GroupData;
import new_package.model.Groups;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withGroupName("Test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withGroupName("Testik").withGroupHeader("testik2").withGroupFooter("Testik3");
    app.goTo().GroupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


  }


}

// app.getSessionHelper().logout();