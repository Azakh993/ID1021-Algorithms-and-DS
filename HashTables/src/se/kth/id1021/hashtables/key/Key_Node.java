package se.kth.id1021.hashtables.key;

class Key_Node {
	private final Integer zipCode;
	private final String name;
	private final Integer population;

	Key_Node( Integer zipCode, String name, Integer population ) {
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
	}

	Integer getZipCode() {
		return zipCode;
	}

	String getName() {
		return name;
	}

	Integer getPopulation() {
		return population;
	}
}
