package moovin.springarchetype.service;

import moovin.springarchetype.domain.Contact;

public interface EntityService {
  void createEntity(Contact contact);

  Contact findEntityByName(String name);
}
