package moovin.springarchetype.dto.response.contact;

import moovin.springarchetype.dto.response.BaseResponse;

import java.util.Objects;

public class ContactForUserResponse extends BaseResponse {
  ContactForUser contact;

  public ContactForUser getContact() {
    return contact;
  }

  public void setContact(ContactForUser contact) {
    this.contact = contact;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactForUserResponse that = (ContactForUserResponse) o;
    return Objects.equals(contact, that.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contact);
  }

  @Override
  public String toString() {
    return "ContactForUserResponse{" +
            "contact=" + contact +
            '}';
  }
}
