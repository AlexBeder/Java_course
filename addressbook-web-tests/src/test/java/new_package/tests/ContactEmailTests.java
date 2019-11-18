package new_package.tests;

import new_package.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactEmailTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstName("Name").withLastName("Familiya").withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroup("[none]"), true);
    }
  }

@Test
  public void testContactEmails(){
  app.contact().gotoHomePage();
  ContactData contact = app.contact().all().iterator().next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));

  }

}
