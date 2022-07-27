package moovin.springarchetype.dto.contact;

import javax.persistence.Id;
import java.util.Objects;

public class ContactForPointDTO extends ContactForPointCreationDTO {
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
    ContactForPointDTO that = (ContactForPointDTO) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id);
  }

  @Override
  public String toString() {
    return "ContactForPoint{" +
            "id=" + id +
            '}';
  }
}
