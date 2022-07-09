package moovin.springarchetype.domain;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "spr_entity_example", schema = "spr_example_db")
public class Entity extends BaseEntity {
  protected Integer id;
  private String name;

  @Override
  public boolean equals(Object o) {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    Entity entity = (Entity) o;
    return Objects.equals(id, entity.id) && Objects.equals(name, entity.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 150)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
