package flightReservation;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Aircraft>{
	
	 public int compare(Aircraft a, Aircraft b)
	    {
	        return  a.getDepartment().compareTo(b.getDepartment());
	    }

}
