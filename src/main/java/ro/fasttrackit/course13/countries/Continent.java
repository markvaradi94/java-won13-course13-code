package ro.fasttrackit.course13.countries;

public enum Continent {
    AFRICA,
    AMERICAS,
    ASIA,
    EUROPE,
    OCEANIA;

    public static Continent of(String value) {
        if (value == null) {
            throw new InvalidContinentException("Null value was passed");
        }

        for (Continent continent : Continent.values()) {
            if (value.equalsIgnoreCase(continent.name())) {
                return continent;
            }
        }

        throw new InvalidContinentException("Could not find continent for value %s".formatted(value));
    }
}
