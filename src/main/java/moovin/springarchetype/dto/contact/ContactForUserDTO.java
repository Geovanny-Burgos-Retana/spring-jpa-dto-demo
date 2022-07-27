package moovin.springarchetype.dto.contact;

import javax.persistence.Id;
import java.util.Objects;

public class ContactForUserDTO extends ContactForUserCreationDTO {
  private Long id;

  @Id
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
    ContactForUserDTO that = (ContactForUserDTO) o;
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
