package flightReservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightManager {

	ArrayList<Reservation> myReservations = new ArrayList<Reservation>();
	ArrayList<Aircraft> airCraft = new ArrayList<Aircraft>();

	public void printAllFlights() {
		ArrayList<String> flightList = new ArrayList<String>();
		flightList.add("AirIndia");
		flightList.add("INDIGO");
		flightList.add("United");
		flightList.add("Emirates");
		for (int i = 0; i < flightList.size(); i++)
			System.out.println(flightList.get(i));

	}

	public ArrayList<Reservation> reserveSeatOnFlight(String flightNumber) {
		myReservations.add(new Reservation(flightNumber));
		return myReservations;
	}

	public ArrayList<Reservation> cancelReservation(String flightNumber) {
		for (int i = 0; i < myReservations.size(); i++) {
			if (flightNumber.equals(myReservations.get(i).flightNumber)) {
				myReservations.remove(i);
				return myReservations;
			}
		}
		return null;
	}

	public boolean seatsAvailable(String flightNum) {
		for (int i = 0; i < myReservations.size(); i++) {
			if (!flightNum.equals(myReservations.get(i).flightNumber)) {
				System.out.println(myReservations.get(i).flightNumber);
				return false;
			}
		}
		return true;
	}

	public String getErrorMessage() {
		String ErrorCode = "Error in confirming the flight";
		return ErrorCode;
	}

	public void printAllAircraft() {

		airCraft.add(new Aircraft("Hawker Hurricane", "Britain", 11.0));
		airCraft.add(new Aircraft("U-2 spy plane", "Chicago", 12.53));
		airCraft.add(new Aircraft("B-52 Stratofortress", "NYC", 15.22));
		airCraft.add(new Aircraft("F-16 Fighting Falcon ", "LA", 18.36));
		for (Aircraft craft : airCraft) {
			System.out.println(craft);
		}
	}

	public void sortAircraft() {
		Collections.sort(airCraft, new SortByName());
        System.out.println("\nSorted by Air Craft");
        for (int i=0; i<airCraft.size(); i++)
            System.out.println(airCraft.get(i));

	}

	public void sortByDeparture() {
		Collections.sort(airCraft, new SortByDepartment());
        System.out.println("\nSorted by Department");
        for (int i=0; i<airCraft.size(); i++)
            System.out.println(airCraft.get(i));

	}

	public void sortByDuration() {
		 Collections.sort(airCraft, new SortByDuration());
	        System.out.println("\nSorted by Duration");
	        for (int i=0; i<airCraft.size(); i++)
	            System.out.println(airCraft.get(i));

	}

	public void myReservationsList() {
		System.out.println("My allReservations");
		for (Reservation str : myReservations) {
			System.out.println(str);
		}
	}

}
