package new_package.tests;

import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.GroupData;
import new_package.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactInGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.contact().list().size() == 0) {
      app.contact().createContact((ContactData) new ContactData()
              .withFirstName("Name").withLastName("Familiya").withAddress("Adres").withHomeTel("704").withEmail("@gmail.com").withGroups(groups), true);
    }
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withGroupName("Test1"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    File photo = new File("src/test/resources/stru.png");
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contactInGroup = before.iterator().next();
    ContactData contact = new ContactData().withId(contactInGroup.getId());
    app.contact().addContactToGroup(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));

    assertThat(after, equalTo(before.without(contactInGroup).withAdded(contact)));
    verifyContactListInUI();
   // app.getSessionHelper().logout();
  }


}
