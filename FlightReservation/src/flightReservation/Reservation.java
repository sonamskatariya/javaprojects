package flightReservation;

public class Reservation {
	
	String flightNumber;

	public Reservation(String flightNumber) {
	this.flightNumber=flightNumber;
	}

	@Override
	public String toString() {
		return "Reservation [flightNumber=" + flightNumber + "]";
	}
	
	
}


