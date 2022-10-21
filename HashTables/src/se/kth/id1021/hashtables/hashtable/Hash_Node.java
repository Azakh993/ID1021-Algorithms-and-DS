package se.kth.id1021.hashtables.hashtable;

public class Hash_Node {
	private final Integer zipCode;
	private final String name;
	private final Integer population;
	private Hash_Node next;

	Hash_Node( Integer zipCode, String name, Integer population ) {
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
		this.next = null;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public String getName() {
		return name;
	}

	public Integer getPopulation() {
		return population;
	}

	public Hash_Node getNext() {
		return next;
	}

	void setNext( Hash_Node next ) {
		this.next = next;
	}
}
