package moovin.springarchetype.dto.response.contact;

import moovin.springarchetype.dto.contact.ContactForUserCreationDTO;

import java.util.Objects;

public class ContactForUser extends ContactForUserCreationDTO {
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ContactForUser that = (ContactForUser) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id);
  }

  @Override
  public String toString() {
    return "ContactForUser{" +
            "id=" + id +
            '}';
  }
}
