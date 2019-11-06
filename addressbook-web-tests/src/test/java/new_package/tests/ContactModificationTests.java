package new_package.tests;

import new_package.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereARecord()) {
      app.getContactHelper().createContact(new ContactData("Name", null, null, null, null, null), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initEditContact();

    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Test2", "Familiya", "Adres", "704", "@gmail.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object> (before), new HashSet<Object>(after));

    app.logout();
  }

}
