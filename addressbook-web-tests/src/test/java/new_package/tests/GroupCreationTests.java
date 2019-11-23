package new_package.tests;

import com.thoughtworks.xstream.XStream;
import new_package.model.GroupData;
import new_package.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
     xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)   xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
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




// String[] split = line.split(";");
//      list.add(new Object[] {new GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])} );