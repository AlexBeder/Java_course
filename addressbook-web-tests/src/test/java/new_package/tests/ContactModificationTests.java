package new_package.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactDetails();
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }

}
