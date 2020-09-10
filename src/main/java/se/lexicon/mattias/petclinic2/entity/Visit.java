package se.lexicon.mattias.petclinic2.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String visitId;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Pet pet;

    private LocalDateTime visitDate;
    private String description;

    public Visit() {
    }

    public Visit(String visitId, Pet pet, LocalDateTime visitDate, String description) {
        this.visitId = visitId;
        this.pet = pet;
        this.visitDate = visitDate;
        this.description = description;
    }

    public Visit(Pet pet, LocalDateTime visitDate, String description) {
        this.pet = pet;
        this.visitDate = visitDate;
        this.description = description;
    }

    /** Getters and setters **/

    public String getVisitId() {
        return visitId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** To String **/

    @Override
    public String toString() {
        return "Visit{" +
                "visitId='" + visitId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
