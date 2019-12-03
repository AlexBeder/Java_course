package new_package.appmanager;

import new_package.model.ContactData;
import new_package.model.Contacts;
import new_package.model.GroupData;
import new_package.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {


  public ContactHelper(ApplicationManager app) {
    super(app);
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void submitContactForm() {
    click(By.xpath("(.//input[@name='submit'])[2]"));

  }


  public void fillContactForm(ContactData contactData, boolean creation) {
    Groups groups = app.db().groups();
    type(By.name("firstname"), contactData.firstName);
    type(By.name("lastname"), contactData.lastName);
    attach(By.name("photo"),contactData.getPhoto());
    type(By.name("address"), contactData.address);
    type(By.name("home"), contactData.homeTel);
    type(By.name("email"), contactData.email);

   if (creation) {
     if (contactData.getGroups().size() > 0) {
       Assert.assertTrue(contactData.getGroups().size() == 1);
       new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(String.valueOf(contactData.getGroups().iterator().next()));
     }
     } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }


  public void initEditContactById(int id) {
    wd.findElement(By.xpath("//tr[./td/input[@id='" + id + "']]//img[@alt=\"Edit\"]")).click();
  }

  public void updateContactForm() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void createContact(ContactData contact, boolean creation) {
    app.goTo().contactCreation();
    fillContactForm((contact), true);
    submitContactForm();
    gotoHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initEditContactById(contact.getId());
    fillContactForm(contact, false);
    updateContactForm();
    gotoHomePage();
  }
  public void addContactToGroup(ContactData contact) {
   // Groups groups = app.db().groups();
    selectContactById(contact.getId());
    Select addToGroup = new Select(wd.findElement(By.xpath("//*[@id=\"content\"]/form[2]/div[4]/select")));
    addToGroup.selectByIndex(1);
    // addToGroup.selectByVisibleText(String.valueOf(contact.getGroups().iterator().next()));
    wd.findElement(By.name("add")).click();
    wd.findElement(By.linkText("home")).click();

  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    confirmDeletion();
  }

  public void create(ContactData contact) {
    app.contact().fillContactForm(contact, true);
    app.contact().submitContactForm();
    app.contact().gotoHomePage();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initEditContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withAddress(address)
            .withHomeTel(home).withMobile(mobile).withWork(work).withEmail(email).withEmail2(email2).withEmail3(email3);

  }
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
    }
    return contacts;
  }
  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return contacts;
  }


}