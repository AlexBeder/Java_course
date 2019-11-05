package new_package.appmanager;

import new_package.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ContactHelper extends HelperBase {


  public ContactHelper(ApplicationManager app) {
    super(app);
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
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

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectContact() {
    click(By.name("selected[]"));

  }

  public void initEditContact() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
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
    app.getNavigationHelper().initContactCreation();
    fillContactForm((contact),true);
    submitContactForm();
    gotoHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
