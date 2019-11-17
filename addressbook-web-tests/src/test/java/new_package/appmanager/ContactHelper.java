package new_package.appmanager;

import new_package.model.ContactData;
import new_package.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    type(By.name("firstname"), contactData.FirstName);
    type(By.name("lastname"), contactData.LastName);
    type(By.name("address"), contactData.Address);
    type(By.name("home"), contactData.HomeTel);
    type(By.name("email"), contactData.Email);

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomeTel(home).withMobile(mobile).withWork(work);

  }
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allEmail = cells.get(4).getText();
      String[] phones = cells.get(5).getText().split("\n");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAddress(address).withEmail(allEmail)
              .withHomeTel(phones[0]).withMobile(phones[1]).withWork(phones[2]));
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
//OLD Code:

//public void initEditContact(int index) {
//
//   wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();
//  }

//  public int getContactCount() {
//    return wd.findElements(By.name("selected[]")).size();
//  }

//  public void delete(int index) {
//    selectContact(index);
//    initContactDeletion();
//    confirmDeletion();
//  }

//  public void selectContact(int index) {
//    wd.findElements(By.name("selected[]")).get(index).click();
//  }


//public Set<ContactData> allSet() {
//    Set<ContactData> contacts = new HashSet<ContactData>();
//    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
//    for (WebElement element : elements){
//      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
//      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
//      String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
//              .withHomeTel(phones[0]).withMobile(phones[1]).withWork(phones[2]));
//    }
//    return contacts;
//  }
//}
