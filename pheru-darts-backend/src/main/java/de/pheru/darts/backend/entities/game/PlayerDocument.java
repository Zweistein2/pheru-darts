package de.pheru.darts.backend.entities.game;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Player_Documents")
public class PlayerDocument {

    @Id
    private String id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id", nullable = false)
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

    public void addAufnahme(final AufnahmeDocument aufnahme) {
        aufnahmen.add(aufnahme);
    }

    public void removeAufnahme(final AufnahmeDocument aufnahme) {
        aufnahmen.remove(aufnahme);
    }
}
