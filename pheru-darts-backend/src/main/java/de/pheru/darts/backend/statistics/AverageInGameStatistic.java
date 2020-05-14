package de.pheru.darts.backend.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageInGameStatistic {

    private Map<Integer, List<Double>> averagesPerAufnahme = new HashMap<>();

    public Map<Integer, List<Double>> getAveragesPerAufnahme() {
        return averagesPerAufnahme;
    }

    public void setAveragesPerAufnahme(final Map<Integer, List<Double>> averagesPerAufnahme) {
        this.averagesPerAufnahme = averagesPerAufnahme;
    }
}
