package se.kth.id1021.graphs;

class Connection {
	private City city;
	private Integer distance;

	Connection( City city, Integer distance ) {
		this.city = city;
		this.distance = distance;
	}

	City getCity() {
		return city;
	}

	void setCity( City city ) {
		this.city = city;
	}

	Integer getDistance() {
		return distance;
	}

	void setDistance( Integer distance ) {
		this.distance = distance;
	}
}
