package moovin.springarchetype.dto.response.contact;

import moovin.springarchetype.dto.contact.ContactForPointDTO;
import moovin.springarchetype.dto.response.BaseResponse;

import java.util.Objects;

public class ContactForPointResponse extends BaseResponse {
  ContactForPointDTO contact;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactForPointResponse that = (ContactForPointResponse) o;
    return Objects.equals(contact, that.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contact);
  }

  @Override
  public String toString() {
    return "ContactForPointResponse{" +
            "contact=" + contact +
            '}';
  }

  public ContactForPointDTO getContact() {
    return contact;
  }

  public void setContact(ContactForPointDTO contact) {
    this.contact = contact;
  }
}
