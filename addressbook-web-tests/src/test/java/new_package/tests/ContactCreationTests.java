package new_package.tests;

import new_package.model.ContactData;
import new_package.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.png");
    list.add(new Object[] {new ContactData().withFirstName("Name 1").withLastName("Familiya 1")
            .withPhoto(photo).withAddress("Adres 1").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]")});
    list.add(new Object[] {new ContactData().withFirstName("Name 2").withLastName("Familiya 2")
            .withPhoto(photo).withAddress("Adres 2").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]")});
    list.add(new Object[] {new ContactData().withFirstName("Name 3").withLastName("Familiya 3")
            .withPhoto(photo).withAddress("Adres 3").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]")});
    return list.iterator();
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
//File photo = new File("src/test/resources/stru.png");
//    ContactData contact = new ContactData()
//            .withFirstName(firstName).withLastName(lastName).withPhoto(photo)
//            .withAddress(address).withHomeTel(homeTel).withEmail(email).withGroup(group);