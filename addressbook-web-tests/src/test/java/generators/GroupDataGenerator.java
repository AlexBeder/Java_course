package generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.thoughtworks.xstream.XStream;
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

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    new JCommander(generator, args);
    generator.run();

  }
  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    if (format.equals("csv")) {
      saveAsCsv(groups, new File (file));
    } else if (format.equals("xml")){
      saveAsXml(groups, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsXml(List<GroupData> groups, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupData.class);
    String xml = xStream.toXML(groups);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private static void saveAsCsv(List<GroupData> groups, File file) throws IOException {
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
