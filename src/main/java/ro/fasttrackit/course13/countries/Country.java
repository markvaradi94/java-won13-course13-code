package ro.fasttrackit.course13.countries;

import lombok.Builder;

import java.util.List;

@Builder
public record Country(
        String name,
        String capital,
        Long population,
        Long area,
        Continent continent,
        List<String> neighbours
) {
}
