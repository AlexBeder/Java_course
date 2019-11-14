package new_package.model;

import java.util.Objects;

public class GroupData {
  public int id = Integer.MAX_VALUE;
  public String GroupName;
  public String GroupHeader;
  public String GroupFooter;

  public int getId() {
    return id;
  }



  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withGroupName(String groupName) {
    GroupName = groupName;
    return this;
  }

  public GroupData withGroupHeader(String groupHeader) {
    GroupHeader = groupHeader;
    return this;
  }

  public GroupData withGroupFooter(String groupFooter) {
    GroupFooter = groupFooter;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", GroupName='" + GroupName + '\'' +
            '}';
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

}
