package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), false);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Familiya", "Adres", "704", "@gmail.com", "[none]"), false);
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }

}
