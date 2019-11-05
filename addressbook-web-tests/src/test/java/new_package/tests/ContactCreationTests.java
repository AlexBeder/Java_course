package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    app.getContactHelper().submitContactForm();
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
    app.logout();
  }


}
