package de.pheru.darts.backend.dtos.game;

public class PlayerDto {

    private String id;
    private DartDto[][] aufnahmen;
    private String playerId;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public DartDto[][] getAufnahmen() {
        return aufnahmen;
    }

    public void setAufnahmen(final DartDto[][] aufnahmen) {
        this.aufnahmen = aufnahmen;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(final String playerId) {
        this.playerId = playerId;
    }
}
