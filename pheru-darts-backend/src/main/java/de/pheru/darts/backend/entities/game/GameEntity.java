package de.pheru.darts.backend.entities.game;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Games")
public class GameEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private Long timestamp;
    private int score;
    private CheckOutMode checkOutMode;
    private CheckInMode checkInMode;
    private Boolean training;
    @ManyToMany
    private List<PlayerDocument> players;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    public CheckInMode getCheckInMode() {
        return checkInMode;
    }

    public CheckInMode getCheckInModeOrDefault() {
        return checkInMode != null ? checkInMode : CheckInMode.defaultValue();
    }

    public void setCheckInMode(final CheckInMode checkInMode) {
        this.checkInMode = checkInMode;
    }

    public CheckOutMode getCheckOutMode() {
        return checkOutMode;
    }

    public void setCheckOutMode(final CheckOutMode checkOutMode) {
        this.checkOutMode = checkOutMode;
    }

    public Boolean isTraining() {
        return training;
    }

    public boolean isTrainingOrDefault() {
        return training != null && training;
    }

    public void setTraining(final Boolean training) {
        this.training = training;
    }

    public List<PlayerDocument> getPlayers() {
        return players;
    }

    public void setPlayers(final List<PlayerDocument> players) {
        this.players = players;
    }
}