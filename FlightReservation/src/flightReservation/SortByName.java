package flightReservation;

import java.util.Comparator;

public class SortByName implements Comparator<Aircraft>{
	
	 public int compare(Aircraft a, Aircraft b)
	    {
	        return  a.getName().compareTo(b.getName());
	    }
}
