package moovin.springarchetype.dto.contact;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class ContactForPointCreationDTO {
  private String name;
  private String phone;
  private String address;

  @NotNull
  @Length(min = 2, max = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @NotNull
  @Pattern(regexp = "^[0-9]{8}$")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @NotNull
  @Length(min = 2, max = 100)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactForPointCreationDTO that = (ContactForPointCreationDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, phone, address);
  }

  @Override
  public String toString() {
    return "ContactForPointCreationDTO{" +
            "name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
}
