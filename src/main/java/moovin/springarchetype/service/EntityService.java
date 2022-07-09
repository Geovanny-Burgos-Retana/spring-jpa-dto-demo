package moovin.springarchetype.service;

import moovin.springarchetype.domain.Entity;

public interface EntityService {
  void createEntity(Entity entity);

  Entity findEntityByName(String name);
}
