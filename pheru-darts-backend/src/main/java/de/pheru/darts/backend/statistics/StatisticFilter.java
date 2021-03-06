package de.pheru.darts.backend.statistics;

import de.pheru.darts.backend.entities.game.CheckInMode;
import de.pheru.darts.backend.entities.game.CheckOutMode;
import de.pheru.darts.backend.util.ComparativeOperator;

import java.util.List;

public class StatisticFilter {

    private List<String> gameIds;
    private List<String> userIds;
    private List<CheckInMode> checkInModes;
    private List<CheckOutMode> checkOutModes;
    private Integer startScore;
    private ComparativeOperator startScoreComparatorOperator;
    private Integer currentScore;
    private ComparativeOperator currentScoreComparativeOperator;
    private Long startDate;
    private Long endDate;

    public List<String> getGameIds() {
        return gameIds;
    }

    public void setGameIds(final List<String> gameIds) {
        this.gameIds = gameIds;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(final List<String> userIds) {
        this.userIds = userIds;
    }

    public List<CheckInMode> getCheckInModes() {
        return checkInModes;
    }

    public void setCheckInModes(final List<CheckInMode> checkInModes) {
        this.checkInModes = checkInModes;
    }

    public List<CheckOutMode> getCheckOutModes() {
        return checkOutModes;
    }

    public void setCheckOutModes(final List<CheckOutMode> checkOutModes) {
        this.checkOutModes = checkOutModes;
    }

    public Integer getStartScore() {
        return startScore;
    }

    public void setStartScore(final Integer startScore) {
        this.startScore = startScore;
    }

    public ComparativeOperator getStartScoreComparatorOperator() {
        return startScoreComparatorOperator;
    }

    public void setStartScoreComparatorOperator(final ComparativeOperator startScoreComparatorOperator) {
        this.startScoreComparatorOperator = startScoreComparatorOperator;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(final Integer currentScore) {
        this.currentScore = currentScore;
    }

    public ComparativeOperator getCurrentScoreComparativeOperator() {
        return currentScoreComparativeOperator;
    }

    public void setCurrentScoreComparativeOperator(final ComparativeOperator currentScoreComparativeOperator) {
        this.currentScoreComparativeOperator = currentScoreComparativeOperator;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(final Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(final Long endDate) {
        this.endDate = endDate;
    }
}