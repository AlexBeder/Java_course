package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Imya", "Familiya", "Adres", "704", "@gmail.com", null), false);
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
    app.logout();
  }

}
