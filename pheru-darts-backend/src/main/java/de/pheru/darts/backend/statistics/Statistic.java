package de.pheru.darts.backend.statistics;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    private DartStatistic darts = new DartStatistic();
    private AufnahmeStatistic aufnahmen = new AufnahmeStatistic();
    private GameStatistic games = new GameStatistic();
    private List<ProgressStatistic> progress = new ArrayList<>();
    private AverageInGameStatistic average = new AverageInGameStatistic();

    public GameStatistic getGames() {
        return games;
    }

    public void setGames(final GameStatistic games) {
        this.games = games;
    }

    public DartStatistic getDarts() {
        return darts;
    }

    public void setDarts(final DartStatistic darts) {
        this.darts = darts;
    }

    public AufnahmeStatistic getAufnahmen() {
        return aufnahmen;
    }

    public void setAufnahmen(final AufnahmeStatistic aufnahmen) {
        this.aufnahmen = aufnahmen;
    }

    public List<ProgressStatistic> getProgress() {
        return progress;
    }

    public void setProgress(final List<ProgressStatistic> progress) {
        this.progress = progress;
    }

    public AverageInGameStatistic getAverage() {
        return average;
    }

    public void setAverage(final AverageInGameStatistic average) {
        this.average = average;
    }
}