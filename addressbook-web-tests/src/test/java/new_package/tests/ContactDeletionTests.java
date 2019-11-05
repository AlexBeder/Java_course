package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmDeletion();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);

  }
}
