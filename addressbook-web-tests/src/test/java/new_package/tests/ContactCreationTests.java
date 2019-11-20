package new_package.tests;

import new_package.model.ContactData;
import new_package.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().contactCreation();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData()
            .withFirstName("Name").withLastName("Familiya").withPhoto(photo)
            .withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    before.add(contact);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }
}
