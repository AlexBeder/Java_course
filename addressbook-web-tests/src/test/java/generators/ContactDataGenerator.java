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

public class ContactDataGenerator {

  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    new JCommander(generator, args);
   generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File (file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getAddress()
              , contact.getHomePhone(), contact.getEmail(), contact.getGroup()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i=0; i<count; i++){
     contacts.add(new ContactData().withFirstName(String.format("Name %s", i))
             .withLastName(String.format("familiya %s", i)).withAddress(String.format("Adres 1", i))
             .withHomeTel(String.format("704", i))
             .withEmail(String.format("@gmail.com", i)).withGroup(String.format("[none]", i)));
    }
    return contacts;
  }
}
