package de.pheru.darts.backend.entities.game;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Dart_Documents")
public class DartDocument {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private int multiplier;
    private int value;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(final int multiplier) {
        this.multiplier = multiplier;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }
}
