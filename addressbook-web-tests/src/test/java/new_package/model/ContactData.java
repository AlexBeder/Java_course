package new_package.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  public int id = Integer.MAX_VALUE;
  public String firstName;
  public String lastName;
  public String address;
  public String homeTel;
  public String mobile;
  public String work;
  public String email;
  public String email2;
  public String email3;
  private String group;
  public String allPhones;
  public String allEmails;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getAllEmails() {
    return allEmails;
  }

   public String getAllPhones() {
    return allPhones;
  }

  public String getHomePhone() {
    return homeTel;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
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
    this.firstName = firstName;
    return this;
  }



  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAllPhones(String AllPhones) {
    this.allPhones = AllPhones;
    return this;
  }

  public ContactData withHomeTel(String homeTel) {
    this.homeTel = homeTel;
    return this;
  }
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAllEmails(String AllEmails) {
    this.allEmails = AllEmails;
    return this;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", FirstName='" + firstName + '\'' +
            ", LastName='" + lastName + '\'' +
            '}';
  }

}

