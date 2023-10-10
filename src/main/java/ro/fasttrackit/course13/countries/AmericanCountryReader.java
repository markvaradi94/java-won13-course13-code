package ro.fasttrackit.course13.countries;

import java.util.List;

public class AmericanCountryReader implements ICountryReader {
    private final String inputFile;

    public AmericanCountryReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    public List<String> getRequestedContinents() {
        return List.of("americas");
    }
}
