package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.goTo().contactCreation();
    ContactData contact = new ContactData()
            .withFirstName("Name").withLastName("Familiya").withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

   // app.getSessionHelper().logout();
  }

}
