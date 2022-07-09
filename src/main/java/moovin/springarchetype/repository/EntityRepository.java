package moovin.springarchetype.repository;

import moovin.springarchetype.domain.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Integer> {
  Entity findByName(String name);
}
