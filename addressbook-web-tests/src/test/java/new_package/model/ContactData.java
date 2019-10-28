package new_package.model;

public class ContactData {
  public String FirstName;
  public String LastName;
  public String Address;
  public String HomeTel;
  public String Email;
  private String group;


  public ContactData (String FirstName, String LastName, String Address, String HomeTel, String Email, String Group) {
  this.FirstName = FirstName;
  this.LastName = LastName;
  this.Address = Address;
  this.HomeTel = HomeTel;
  this.Email = Email;
  this.group = Group;
  }

  public String getGroup() {
    return group;
  }
}