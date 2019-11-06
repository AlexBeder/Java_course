package new_package.model;

import java.util.Objects;

public class ContactData {
  public String FirstName;
  public String LastName;
  public String Address;
  public String HomeTel;
  public String Email;
  private String group;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(FirstName, that.FirstName) &&
            Objects.equals(LastName, that.LastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(FirstName, LastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "FirstName='" + FirstName + '\'' +
            ", LastName='" + LastName + '\'' +
            '}';
  }

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