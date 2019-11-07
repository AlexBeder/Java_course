package new_package.model;

import java.util.Objects;

public class GroupData {
  public int id;
  public String GroupName;
  public String GroupHeader;
  public String GroupFooter;

  public GroupData (String GroupName, String GroupHeader, String GroupFooter){
    this.id=0;
    this.GroupName = GroupName;
    this.GroupHeader = GroupHeader;
    this.GroupFooter = GroupFooter;
  }

  public GroupData (int id, String GroupName, String GroupHeader, String GroupFooter){
    this.id=id;
    this.GroupName = GroupName;
    this.GroupHeader = GroupHeader;
    this.GroupFooter = GroupFooter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(GroupName, groupData.GroupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, GroupName);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", GroupName='" + GroupName + '\'' +
            '}';
  }





}
