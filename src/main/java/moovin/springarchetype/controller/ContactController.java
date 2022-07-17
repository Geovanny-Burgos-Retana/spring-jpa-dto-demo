package moovin.springarchetype.controller;

import lombok.extern.log4j.Log4j2;
import moovin.springarchetype.domain.Contact;
import moovin.springarchetype.dto.contact.ContactForPointCreationDTO;
import moovin.springarchetype.dto.contact.ContactForUserCreationDTO;
import moovin.springarchetype.dto.response.contact.ContactForPointResponse;
import moovin.springarchetype.dto.response.contact.ContactForUserResponse;
import moovin.springarchetype.service.ContactService;
import moovin.springarchetype.utils.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/archetype/api/v1/contact")
public class ContactController {
  private final ContactService contactService;

  @Autowired
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  @PostMapping(value = "/forPoint", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ContactForPointResponse> createContactForPoint(@DTO(ContactForPointCreationDTO.class) Contact contact,
                                                                       Errors errors) {
    HttpStatus httpStatus = HttpStatus.OK;
    ContactForPointResponse contactForPointResponse = new ContactForPointResponse();
    if (errors.hasErrors()) {
      contactForPointResponse.setMessage("ERROR " + errors);
      contactForPointResponse.setStatus("ERRORDATAINPUT");
      httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
      return new ResponseEntity<>(contactForPointResponse, httpStatus);
    }
    return new ResponseEntity<>(contactService.createContactForPoint(contact), httpStatus);
  }

  @PostMapping(value = "/forUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ContactForUserResponse> createContactForUser(@DTO(ContactForUserCreationDTO.class) Contact contact,
                                                                     Errors errors) {
    HttpStatus httpStatus = HttpStatus.OK;
    ContactForUserResponse contactForUserResponse = new ContactForUserResponse();
    if (errors.hasErrors()) {
      contactForUserResponse.setMessage("ERROR " + errors);
      contactForUserResponse.setStatus("ERRORDATAINPUT");
      httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
      return new ResponseEntity<>(contactForUserResponse, httpStatus);
    }
    return new ResponseEntity<>(contactService.createContactForUser(contact), httpStatus);
  }
}
