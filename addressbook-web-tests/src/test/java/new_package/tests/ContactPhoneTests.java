package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase {

@Test
  public void testContactPhones(){
  app.contact().gotoHomePage();
  ContactData contact = app.contact().all().iterator().next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
}


}
