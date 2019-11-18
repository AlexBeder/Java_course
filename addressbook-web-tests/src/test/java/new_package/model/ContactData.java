package new_package.model;

import java.util.Objects;

public class ContactData {
  public int id = Integer.MAX_VALUE;
  public String FirstName;
  public String LastName;
  public String Address;
  public String HomeTel;
  public String Mobile;
  public String Work;
  public String Email;
  private String group;
  public String AllPhones;


  public String getAllPhones() {
    return AllPhones;
  }

  public String getHomePhone() {
    return HomeTel;
  }

  public String getMobilePhone() {
    return Mobile;
  }

  public String getWorkPhone() {
    return Work;
  }

  public int getId() {
    return id;
  }

  public String getGroup() {
    return group;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    FirstName = firstName;
    return this;
  }



  public ContactData withLastName(String lastName) {
    LastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    Address = address;
    return this;
  }

  public ContactData withAllPhones(String AllPhones) {
    this.AllPhones = AllPhones;
    return this;
  }

  public ContactData withHomeTel(String homeTel) {
    HomeTel = homeTel;
    return this;
  }
  public ContactData withMobile(String mobile) {
    Mobile = mobile;
    return this;
  }
  public ContactData withWork(String work) {
    Work = work;
    return this;
  }

  public ContactData withEmail(String email) {
    Email = email;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
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

}

