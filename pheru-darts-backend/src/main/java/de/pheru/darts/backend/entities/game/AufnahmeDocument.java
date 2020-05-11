package de.pheru.darts.backend.entities.game;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Aufnahme_Documents")
public class AufnahmeDocument {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @OneToMany
    private List<DartDocument> darts;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<DartDocument> getDarts() {
        return darts;
    }

    public void setDarts(final List<DartDocument> darts) {
        this.darts = darts;
    }
}
