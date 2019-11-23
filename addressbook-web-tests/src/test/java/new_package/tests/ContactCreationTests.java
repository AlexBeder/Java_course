package new_package.tests;

import com.thoughtworks.xstream.XStream;
import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.GroupData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)   xstream.fromXML(xml);
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation( ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    app.goTo().contactCreation();

    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    before.add(contact);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }
}


//String line = reader.readLine();
//    while (line != null) {
//      String[] split = line.split(";");
//      list.add(new Object[]{new ContactData().withFirstName(split[0]).withLastName(split[1])
//              .withPhoto(photo).withAddress(split[2]).withHomeTel(split[3]).withEmail(split[4]).withGroup(split[5])});
//      line = reader.readLine();
//    }
//    return list.iterator();