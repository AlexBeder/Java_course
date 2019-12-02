package new_package.tests;

import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.contact().list().size() == 0) {
      app.contact().createContact((ContactData) new ContactData()
              .withFirstName("Name").withLastName("Familiya").withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroups(groups), true);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo((before.size() - 1)));

    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }


}
