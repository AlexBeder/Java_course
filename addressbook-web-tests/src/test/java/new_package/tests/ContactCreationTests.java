package new_package.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactDetails();
    app.getContactHelper().submitContactForm();
    app.getContactHelper().gotoHomePage();
    app.logout();
  }


}
