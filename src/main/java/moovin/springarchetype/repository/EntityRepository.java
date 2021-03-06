package moovin.springarchetype.repository;

import moovin.springarchetype.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Contact, Integer> {
  Contact findByName(String name);
}
