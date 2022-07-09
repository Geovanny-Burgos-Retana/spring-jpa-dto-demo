/******************************************************************************
 * Moovin Mensajería Express. Derechos Reservados (c) 2020.                    *
 * Creado por Alvaro Araya aaraya@moovin.me                                   *
 ******************************************************************************/
package moovin.springarchetype.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {
  protected Timestamp dateCreated;
  protected Timestamp dateModified;

  @PrePersist
  @PreUpdate
  public void audit() {
    this.dateCreated = this.dateCreated == null ? new Timestamp(System.currentTimeMillis()) : this.dateCreated;
    this.dateModified = new Timestamp(System.currentTimeMillis());
  }

  @CreationTimestamp
  @Column(name = "date_created", nullable = false)
  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  @UpdateTimestamp
  @Column(name = "date_updated", nullable = false)
  public Timestamp getDateModified() {
    return dateModified;
  }

  public void setDateModified(Timestamp dateModified) {
    this.dateModified = dateModified;
  }
}
