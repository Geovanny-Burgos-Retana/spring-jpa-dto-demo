package moovin.springarchetype.service;

import moovin.springarchetype.domain.Contact;
import moovin.springarchetype.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {
  private final EntityRepository entityRepository;

  @Autowired
  public EntityServiceImpl(EntityRepository entityRepository) {
    this.entityRepository = entityRepository;
  }

  @Override
  public void createEntity(Contact contact) {
    this.entityRepository.save(contact);
  }

  @Override
  public Contact findEntityByName(String name) {
    return entityRepository.findByName(name);
  }
}

