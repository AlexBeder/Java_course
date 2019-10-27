package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactDetails(new ContactData("Name", "Familiya", "Adres", "704", "@gmail.com"));
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }

}
