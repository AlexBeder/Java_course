package new_package.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")

public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  public int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  public String groupName;

  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  public String groupHeader;

  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  public String groupFooter;

  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  public int getId() {
    return id;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public GroupData withGroupHeader(String groupHeader) {
    this.groupHeader = groupHeader;
    return this;
  }

  public GroupData withGroupFooter(String groupFooter) {
    this.groupFooter = groupFooter;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", GroupName='" + groupName + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(groupName, groupData.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupName);
  }

}
