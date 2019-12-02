package generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import new_package.model.ContactData;
import new_package.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter (names = "-a", description = "Contact count")
  public int count;

  @Parameter (names = "-b", description = "Target file")
  public String file;

  @Parameter (names = "-s", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    new JCommander(generator, args);
   generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File (file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    }    else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }
  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getAddress()
                , contact.getHomePhone(), contact.getEmail(), contact.getGroups()));
      }
    }
  }

  private List<ContactData> generateContacts(int count) {
    File photo = new File("src/test/resources/stru.png");
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i=0; i<count; i++){
     contacts.add(new ContactData().withFirstName(String.format("Name %s", i))
             .withLastName(String.format("familiya %s", i)).withPhoto(photo).withAddress(String.format("Adres 1", i))
             .withHomeTel(String.format("704", i))
             .withEmail(String.format("@gmail.com", i)));
    }
    return contacts;
  }
}
