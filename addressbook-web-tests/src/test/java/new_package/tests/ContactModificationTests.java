package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size());
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Imya", "Familiya", "Adres", "704", "@gmail.com", null), false);
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    app.logout();
  }

}
