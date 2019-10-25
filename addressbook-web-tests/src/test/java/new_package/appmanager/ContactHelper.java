package new_package.appmanager;

import new_package.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  public void gotoHomePage() {
   click(By.linkText("home page"));
 }

  public void submitContactForm() {
  click(By.xpath("(.//input[@name='submit'])[2]"));
 }

  public void fillContactDetails() {
   ContactData ContactParam = new ContactData ("Sasha", "Test", "Adres", "704 home tel", "test@test.com");
    type(By.name("firstname"), ContactParam.FirstName);
    type(By.name("lastname"), ContactParam.LastName);
    type(By.name("address"), ContactParam.Address);
    type(By.name("home"), ContactParam.HomeTel);
    type(By.name("email"), ContactParam.Email);
   }
}
