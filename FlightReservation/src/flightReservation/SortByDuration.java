package flightReservation;

import java.util.Comparator;

public class SortByDuration implements Comparator<Aircraft>
{
    // Used for sorting in ascending order of
  
    public int compare(Aircraft a, Aircraft b)
    {
        return (int) (a.duration - b.duration);
    }
}