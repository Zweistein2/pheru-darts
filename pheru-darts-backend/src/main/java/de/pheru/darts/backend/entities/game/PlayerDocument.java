package de.pheru.darts.backend.entities.game;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Player_Documents")
public class PlayerDocument {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @OneToMany
    private List<AufnahmeDocument> aufnahmen;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<AufnahmeDocument> getAufnahmen() {
        return aufnahmen;
    }

    public void setAufnahmen(final List<AufnahmeDocument> aufnahmen) {
        this.aufnahmen = aufnahmen;
    }
}
