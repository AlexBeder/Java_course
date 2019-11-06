package new_package.model;

import java.util.Objects;

public class GroupData {
  public String GroupName;
  public String GroupHeader;
  public String GroupFooter;

  public GroupData (String GroupName, String GroupHeader, String GroupFooter){
    this.GroupName = GroupName;
    this.GroupHeader = GroupHeader;
    this.GroupFooter = GroupFooter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(GroupName, groupData.GroupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(GroupName);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "GroupName='" + GroupName + '\'' +
            '}';
  }
}
