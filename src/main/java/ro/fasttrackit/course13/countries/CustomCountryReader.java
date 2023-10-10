package ro.fasttrackit.course13.countries;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class CustomCountryReader implements ICountryReader {
    private final String inputFile;
    private final List<String> continentFilters;

    public CustomCountryReader(String inputFile, List<String> continentFilters) {
        this.inputFile = inputFile;
        this.continentFilters = new ArrayList<>(continentFilters);
    }

    public String getInputFile() {
        return inputFile;
    }

    public List<String> getRequestedContinents() {
        return new ArrayList<>(continentFilters);
    }
}
