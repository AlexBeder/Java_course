package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Familiya", "Adres", "704","@gmail.com", "[none]"), true);
    app.getContactHelper().submitContactForm();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.logout();
  }


}
