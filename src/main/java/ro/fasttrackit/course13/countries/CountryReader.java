package ro.fasttrackit.course13.countries;

import java.util.List;

public class CountryReader implements ICountryReader {
    private final String inputFile;

    public CountryReader(String inputFile) {
        this.inputFile = inputFile;
    }


    public String getInputFile() {
        return inputFile;
    }

    public List<String> getRequestedContinents() {
        return null;
    }
}
