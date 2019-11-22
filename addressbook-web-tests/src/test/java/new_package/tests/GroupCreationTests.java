package new_package.tests;

import new_package.model.GroupData;
import new_package.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])} );
      line = reader.readLine();
    }
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


//list.add(new Object[] {new GroupData().withGroupName("test 1").withGroupHeader("header 1").withGroupFooter("footer 1")});
//    list.add(new Object[] {new GroupData().withGroupName("test 2").withGroupHeader("header 2").withGroupFooter("footer 2")});
//    list.add(new Object[] {new GroupData().withGroupName("test 3").withGroupHeader("header 3").withGroupFooter("footer 3")});