package moovin.springarchetype.service;

import moovin.springarchetype.domain.Contact;
import moovin.springarchetype.dto.response.contact.ContactForPoint;
import moovin.springarchetype.dto.response.contact.ContactForPointResponse;
import moovin.springarchetype.dto.response.contact.ContactForUser;
import moovin.springarchetype.dto.response.contact.ContactForUserResponse;
import moovin.springarchetype.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
  private final ContactRepository contactRepository;
  private final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  public ContactServiceImpl(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  public ContactForPointResponse createContactForPoint(Contact contact) {
    ContactForPointResponse contactForPointResponse = new ContactForPointResponse();
    Optional<Contact> contactSaved = Optional.ofNullable(contactRepository.save(contact));
    if (contactSaved.isPresent()) {
      contactForPointResponse.setContact(modelMapper.map(contactSaved.get(), ContactForPoint.class));
      contactForPointResponse.setStatus("SUCCESS");
      contactForPointResponse.setMessage("Complete");
    } else {
      contactForPointResponse.setStatus("NOTCREATED");
      contactForPointResponse.setMessage("No created contact of point");
    }
    return contactForPointResponse;
  }

  @Override
  public ContactForUserResponse createContactForUser(Contact contact) {
    ContactForUserResponse contactForUserResponse = new ContactForUserResponse();
    Optional<Contact> contactSaved = Optional.ofNullable(contactRepository.save(contact));
    if (contactSaved.isPresent()) {
      contactForUserResponse.setContact(modelMapper.map(contactSaved.get(), ContactForUser.class));
      contactForUserResponse.setStatus("SUCCESS");
      contactForUserResponse.setMessage("Complete");
    } else {
      contactForUserResponse.setStatus("NOTCREATED");
      contactForUserResponse.setMessage("No created contact of user");
    }
    return contactForUserResponse;
  }
}
