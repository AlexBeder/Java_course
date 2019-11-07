package new_package.model;

import java.util.Objects;

public class ContactData {
  public int id;
  public String FirstName;
  public String LastName;
  public String Address;
  public String HomeTel;
  public String Email;
  private String group;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ContactData (int id, String FirstName, String LastName, String Address, String HomeTel, String Email, String Group) { this.FirstName = FirstName;
  this.id=id;
  this.FirstName = FirstName;
  this.LastName = LastName;
  this.Address = Address;
  this.HomeTel = HomeTel;
  this.Email = Email;
  this.group = Group;
  }



  public ContactData (String FirstName, String LastName, String Address, String HomeTel, String Email, String Group) { this.FirstName = FirstName;
    this.id=0;
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.Address = Address;
    this.HomeTel = HomeTel;
    this.Email = Email;
    this.group = Group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(FirstName, that.FirstName) &&
            Objects.equals(LastName, that.LastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, FirstName, LastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", FirstName='" + FirstName + '\'' +
            ", LastName='" + LastName + '\'' +
            '}';
  }



  public String getGroup() {
    return group;
  }
}