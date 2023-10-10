package ro.fasttrackit.course13.countries;

import java.util.ArrayList;
import java.util.List;

public class CountriesMain {
    public static void main(String[] args) {
        List<String> contFilt = new ArrayList<>();
        contFilt.add("europe");
        contFilt.add("africa");
        CustomCountryReader reader = new CustomCountryReader("files/input/countries.txt", contFilt);
//        List<Country> countries = reader.readCountries();
//
//        for (Country country : countries) {
//            System.out.println(country);
//        }


        System.out.println(reader);
        List<String> requestedContinents = reader.getRequestedContinents();
        contFilt.add("test");
        System.out.println(reader);
    }
}
