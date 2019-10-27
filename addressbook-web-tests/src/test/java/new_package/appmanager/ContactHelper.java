package new_package.appmanager;

import new_package.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactForm() {
    click(By.xpath("(.//input[@name='submit'])[2]"));

  }


  public void fillContactDetails(ContactData contactData) {
    type(By.name("firstname"), contactData.FirstName);
    type(By.name("lastname"), contactData.LastName);
    type(By.name("address"), contactData.Address);
    type(By.name("home"), contactData.HomeTel);
    type(By.name("email"), contactData.Email);
  }

  public void selectContact() {
    click(By.name("selected[]"));

  }

  public void initEditContact() {
    click(By.xpath("(.//img[@alt='Edit'])[2]"));
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
}
