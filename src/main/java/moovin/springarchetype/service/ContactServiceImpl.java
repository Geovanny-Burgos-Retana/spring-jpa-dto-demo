package moovin.springarchetype.service;

import moovin.springarchetype.domain.Contact;
import moovin.springarchetype.dto.contact.ContactForPointDTO;
import moovin.springarchetype.dto.contact.ContactForUserDTO;
import moovin.springarchetype.dto.response.contact.ContactForPointResponse;
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
      contactForPointResponse.setContact(modelMapper.map(contactSaved.get(), ContactForPointDTO.class));
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
      contactForUserResponse.setContact(modelMapper.map(contactSaved.get(), ContactForUserDTO.class));
      contactForUserResponse.setStatus("SUCCESS");
      contactForUserResponse.setMessage("Complete");
    } else {
      contactForUserResponse.setStatus("NOTCREATED");
      contactForUserResponse.setMessage("No created contact of user");
    }
    return contactForUserResponse;
  }

  @Override
  public ContactForPointResponse getContactForPoint(Long id) {
    ContactForPointResponse contactForPointResponse = new ContactForPointResponse();
    Optional<Contact> contactFound = contactRepository.findById(id);
    if (contactFound.isPresent()) {
      contactForPointResponse.setContact(modelMapper.map(contactFound.get(), ContactForPointDTO.class));
      contactForPointResponse.setStatus("SUCCESS");
      contactForPointResponse.setMessage("Complete");
    } else {
      contactForPointResponse.setStatus("NOTFOUND");
      contactForPointResponse.setMessage("No found contact of point");
    }
    return contactForPointResponse;
  }

  @Override
  public ContactForUserResponse getContactForUser(Long id) {
    ContactForUserResponse contactForUserResponse = new ContactForUserResponse();
    Optional<Contact> contactFound = contactRepository.findById(id);
    if (contactFound.isPresent()) {
      contactForUserResponse.setContact(modelMapper.map(contactFound.get(), ContactForUserDTO.class));
      contactForUserResponse.setStatus("SUCCESS");
      contactForUserResponse.setMessage("Complete");
    } else {
      contactForUserResponse.setStatus("NOTFOUND");
      contactForUserResponse.setMessage("No found contact of user");
    }
    return contactForUserResponse;
  }
}
