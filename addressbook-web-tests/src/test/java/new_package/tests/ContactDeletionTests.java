package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmDeletion();

  }
}
