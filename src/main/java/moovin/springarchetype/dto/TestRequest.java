package moovin.springarchetype.dto;

public class TestRequest {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "TestRequest{" +
        "message='" + message + '\'' +
        '}';
  }
}
