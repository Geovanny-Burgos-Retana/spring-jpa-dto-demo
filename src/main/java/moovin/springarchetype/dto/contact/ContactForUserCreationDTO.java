package moovin.springarchetype.dto.contact;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class ContactForUserCreationDTO {
  private String name;
  private String lastName;
  private String phone;
  private String cellPhone;
  private String mail;
  private String password;

  @NotNull
  @NotBlank
  @Length(min = 2, max = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @NotNull
  @NotBlank
  @Length(min = 2, max = 100)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @NotNull
  @NotBlank
  @Pattern(regexp = "^[0-9]{8}$")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @NotNull
  @NotBlank
  @Pattern(regexp = "^[0-9]{8}$")
  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  @NotNull
  @NotBlank
  @Email
  @Length(min = 2, max = 100)
  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  @NotNull
  @NotBlank
  @Length(min = 8, max = 20)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactForUserCreationDTO that = (ContactForUserCreationDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(phone, that.phone) && Objects.equals(cellPhone, that.cellPhone) && Objects.equals(mail, that.mail) && Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName, phone, cellPhone, mail, password);
  }

  @Override
  public String toString() {
    return "ContactForUserCreationDTO{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phone='" + phone + '\'' +
            ", cellPhone='" + cellPhone + '\'' +
            ", mail='" + mail + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
