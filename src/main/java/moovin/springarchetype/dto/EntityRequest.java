package moovin.springarchetype.dto;

public class EntityRequest {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "EntityRequest{" +
        "name='" + name + '\'' +
        '}';
  }
}
