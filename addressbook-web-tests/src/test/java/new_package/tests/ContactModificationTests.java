package new_package.tests;

import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.contact().list().size() == 0) {
      app.contact().createContact((ContactData) new ContactData()
              .withFirstName("Name").withLastName("Familiya").withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroups(groups), true);
    }
  }

  @Test
  public void testContactModification() {
    File photo = new File("src/test/resources/stru.png");
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
                  .withId(modifiedContact.getId()).withFirstName("Name").withLastName("Familiya")
            .withPhoto(photo).withAddress("Adres").withHomeTel("704").withEmail("@gmail.com");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
   // app.getSessionHelper().logout();
  }


}
