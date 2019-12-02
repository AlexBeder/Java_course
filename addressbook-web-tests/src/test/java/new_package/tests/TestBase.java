package new_package.tests;

import new_package.appmanager.ApplicationManager;
import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.GroupData;
import new_package.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }
  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) { //enable by adding "-DverifyUI=true" in the class config
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withGroupName(g.getGroupName()))
              .collect(Collectors.toSet())));
    }
  }
  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) { //enable by adding "-DverifyUI=true" in the class config
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName())
                      .withLastName(c.getLastName()).withAddress(c.getAddress())
                      .withHomeTel(c.getHomePhone()).withEmail(c.getEmail())).collect(Collectors.toSet())));
    }
  }
}

//.withPhoto(c.getPhoto())