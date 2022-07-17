package moovin.springarchetype.service;

import moovin.springarchetype.domain.Contact;
import moovin.springarchetype.dto.response.contact.ContactForPointResponse;
import moovin.springarchetype.dto.response.contact.ContactForUserResponse;


public interface ContactService {
  ContactForPointResponse createContactForPoint(Contact contact);

  ContactForUserResponse createContactForUser(Contact contact);
}
