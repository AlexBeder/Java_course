package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactDetails(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com"));
    app.getContactHelper().submitContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }


}
