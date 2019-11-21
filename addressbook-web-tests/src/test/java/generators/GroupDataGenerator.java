package generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import new_package.model.ContactData;
import new_package.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    new JCommander(generator, args);
    generator.run();

  }
  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    save(groups, new File (file));
  }

   private static void save(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups){
      writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupFooter(), group.getGroupFooter()));
    }
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i=0; i<count; i++){
     groups.add(new GroupData().withGroupName(String.format("test %s", i))
             .withGroupFooter(String.format("test %s", i)).withGroupHeader(String.format("test %s", i)));
    }
    return groups;
  }
}
