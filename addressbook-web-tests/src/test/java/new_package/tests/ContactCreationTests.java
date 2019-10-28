package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    app.getContactHelper().submitContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }


}
