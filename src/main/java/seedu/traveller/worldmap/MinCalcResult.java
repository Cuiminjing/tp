package seedu.traveller.worldmap;

import java.util.List;

//@@author jach23
/**
 * This class is mainly used by the WorldMap class to store the path of the
 * shortest time or cost, containing both starting and ending countries
 * along with the shortest path.
 */
public class MinCalcResult {
    private final Country startCountry;
    private final Country endCountry;
    private final List<Country> path;
    private final List<Double> time;
    private int error;

    public MinCalcResult(Country startCountry, Country endCountry, List<Country> path, List<Double> time) {
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.path = path;
        this.time = time;
        this.error = 0;
    }

    public void setError() {
        error = 1;
    }

    public Country getStartCountry() {
        return this.startCountry;
    }

    public Country getEndCountry() {
        return endCountry;
    }

    public List<Country> getPath() {
        return path;
    }

    public List<Double> getTime() {
        return time;
    }

    public int getError() {
        return error;
    }

    @Override
    public String toString() {
        return "minCalcResult:\n\t" + getStartCountry() + " to " + getEndCountry()
                + "\n\t" + getPath() + "\n\t" + getTime();
    }
}
