package de.pheru.darts.backend.testutil;

import de.pheru.darts.backend.entities.game.AufnahmeDocument;
import de.pheru.darts.backend.entities.game.PlayerDocument;

import java.util.ArrayList;

public class PlayerDocumentBuilder {

    private final PlayerDocument document = new PlayerDocument();

    public PlayerDocumentBuilder() {
        document.setAufnahmen(new ArrayList<>());
    }

    public PlayerDocumentBuilder playerId(final String id) {
        document.setPlayerId(id);
        return this;
    }

    public PlayerDocumentBuilder aufnahme(final AufnahmeDocument aufnahmeDocument) {
        document.getAufnahmen().add(aufnahmeDocument);
        return this;
    }

    public PlayerDocument build() {
        return document;
    }

}
