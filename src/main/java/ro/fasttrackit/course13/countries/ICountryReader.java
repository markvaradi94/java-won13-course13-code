package ro.fasttrackit.course13.countries;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public interface ICountryReader {

    String getInputFile();

    List<String> getRequestedContinents();

    default List<Country> readCountries() {
        List<Country> countries = new ArrayList<>();
        try (Scanner scanner = new Scanner(Path.of(getInputFile()))) {
            while (scanner.hasNextLine()) {
                Country country = buildCountry(scanner.nextLine());
                if (getRequestedContinents() == null || isFromRequestedContinents(country)) {
                    countries.add(country);
                }
            }
            return countries;
        } catch (IOException exception) {
            throw new CountryReadException("Could not read countries, error was thrown: %s".formatted(exception.getMessage()));
        }
    }

    private boolean isFromRequestedContinents(Country country) {
        List<Continent> continents = mapToContinents();
        return continents.contains(country.continent());
    }

    private List<Continent> mapToContinents() {
        List<Continent> continents = new ArrayList<>();
        for (String requestedContinent : getRequestedContinents()) {
            Continent parsedContinent = parseContinent(requestedContinent);
            if (parsedContinent != null) {
                continents.add(Continent.of(requestedContinent));
            }
        }
        return continents;
    }

    private Continent parseContinent(String value) {
        try {
            return Continent.of(value);
        } catch (InvalidContinentException exception) {
//            System.err.printf("Invalid continent value was recieved: %s%n", value);
            return null;
        }
    }

    private Country buildCountry(String line) {
        String[] tokens = line.split("[|]");
        return Country.builder()
                .name(tokens[0])
                .capital(tokens[1])
                .population(Long.parseLong(tokens[2]))
                .area(Long.parseLong(tokens[3]))
                .continent(Continent.of(tokens[4]))
                .neighbours(tokens.length == 6 ? neighboursList(tokens[5]) : List.of())
                .build();
    }

    private List<String> neighboursList(String neighboursString) {
        return asList(neighboursString.split("~"));
    }
}
