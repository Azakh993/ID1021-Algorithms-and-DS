package se.kth.id1021.hashtables.string;

class String_Node {
	private final String zipCode;
	private final String name;
	private final Integer population;

	String_Node( String zipCode, String name, Integer population ) {
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
	}

	String getZipCode() {
		return zipCode;
	}

	String getName() {
		return name;
	}

	Integer getPopulation() {
		return population;
	}
}
