package moovin.springarchetype.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@javax.persistence.Entity
@Table(name = "contact", schema = "dtos_demo")
public class Contact extends BaseEntity {
  private Long id;
  private String name;
  private String lastName;
  private String phone;
  private String cellPhone;
  private String address;
  private String mail;
  private String password;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Basic
  @Length(min = 2, max = 100)
  @Column(name = "name", length = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Length(min = 2, max = 100)
  @Column(name = "last_name", length = 100)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Pattern(regexp = "^[0-9]{8}$")
  @Column(name = "phone", length = 20)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Basic
  @Pattern(regexp = "^[0-9]{8}$")
  @Column(name = "cell_phone", length = 20)
  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  @Basic
  @Length(min = 2, max = 100)
  @Column(name = "address", length = 100)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Email
  @Column(name = "mail", length = 100)
  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  @Basic
  @Length(min = 8, max = 20)
  @Column(name = "password", length = 20)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
