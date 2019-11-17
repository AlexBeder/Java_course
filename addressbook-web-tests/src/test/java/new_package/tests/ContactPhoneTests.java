package new_package.tests;

import new_package.model.ContactData;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactPhoneTests extends TestBase {

@Test
  public void testContactPhones(){
  app.contact().gotoHomePage();
  ContactData contact = app.contact().all().iterator().next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  assertThat(contact.getAllPhones(), equalTo(contactInfoFromEditForm.getHomeTel()));
// assertThat(contact.getMobile(), equalTo(contactInfoFromEditForm.getMobile()));
//  assertThat(contact.getWork(), equalTo(contactInfoFromEditForm.getWork()));
}
}
