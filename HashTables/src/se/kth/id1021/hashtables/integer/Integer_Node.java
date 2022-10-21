package se.kth.id1021.hashtables.integer;

public class Integer_Node {
	private final Integer zipCode;
	private final String name;
	private final Integer population;

	Integer_Node( Integer zipCode, String name, Integer population ) {
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public String getName() {
		return name;
	}

	Integer getPopulation() {
		return population;
	}
}
