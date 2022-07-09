package moovin.springarchetype.dto;

public class EntityResponse {
  String status;
  String message;
  String entityName;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEntityName() {
    return entityName;
  }

  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }

  @Override
  public String toString() {
    return "EntityResponse{" +
        "status='" + status + '\'' +
        ", message='" + message + '\'' +
        ", entityName='" + entityName + '\'' +
        '}';
  }
}
