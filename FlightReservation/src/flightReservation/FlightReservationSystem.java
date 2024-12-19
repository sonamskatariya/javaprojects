package flightReservation;

import java.util.ArrayList;

import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!


public class FlightReservationSystem

{

    public static void main(String[] args)

    {

        // Create a FlightManager object

        FlightManager manager = new FlightManager();

        // List of reservations that have been made

        ArrayList<Reservation> myReservations = new ArrayList<Reservation>();   // my flight reservations

        
        System.out.println(" 1.LIST \n 2.CANCEL \n 3.QUIT \n 4.RES \n 5.RESFCL \n 6.SEATS \n 7.MYRES \n 8.CRAFT \n 9.SORTCRAFT \n 11.SORTBYDEP \n 12.SORTBYDUR");

        System.out.print(">");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())

        {

            String inputLine = scanner.nextLine();

            if (inputLine == null || inputLine.equals("")) continue;

            // The command line is a scanner that scans the inputLine string

            // For example: list AC201

            Scanner commandLine = new Scanner(inputLine);

            

            // The action string is the command to be performed (e.g. list, cancel etc)

            String action = commandLine.next();

            if (action == null || action.equals("")) continue;

            if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT")) {
            	System.out.println("Have a Nice Day !!!");
                return;
            }
            

            // List all flights

            else if (action.equalsIgnoreCase("LIST"))

            {

                manager.printAllFlights();

            }

            // Reserve a flight based on Flight number string (example input: res AC220)

            else if (action.equalsIgnoreCase("RES"))

            {

                // Get the flight number string from the commndLine scanner (use hasNext() to check if there is a
            	System.out.println("Enter the Flight Number");
                Scanner scanInput = new Scanner(System.in);
                String inputFlightNumber=null;
                if(scanner.hasNext())
                inputFlightNumber = scanner.next();
                // call reserveSeatOnFlight() method in manager passing in the flight number string
                    myReservations = manager.reserveSeatOnFlight(inputFlightNumber);

                // A reference to a Reservation object is returned. Check to make sure it is not == null
                    if(myReservations==null)
                    	manager.getErrorMessage();// If it is null, then call manager.getErrorMessage() and print the message
                    else
                    	System.out.println("Reservation done for Flight Numeber" + inputFlightNumber);// If it is not null, add the reservation to the myReservations array list and print the reservation (see class Reservation)
                
            }
          // Reserve a first class seat on a flight based on Flight number string (example input: res AC220)

            else if (action.equalsIgnoreCase("RESFCL"))

            {
            	System.out.println("Enter the Flight Number");
                Scanner scanInput = new Scanner(System.in);
                String inputFlightNumber=null;
            	 if(scanner.hasNext())
                     inputFlightNumber = scanner.next();
                     // call reserveSeatOnFlight() method in manager passing in the flight number string
                         myReservations = manager.reserveSeatOnFlight(inputFlightNumber);

                     // A reference to a Reservation object is returned. Check to make sure it is not == null
                         if(myReservations==null)
                         	manager.getErrorMessage();// If it is null, then call manager.getErrorMessage() and print the message
                         else
                         	System.out.println("Reservation done for Flight Numeber" + inputFlightNumber);
                     
                // manager.reserveSeatOnFlight() and pass in the flight number string as well as the string constant:

                // LongHaulFlight.firstClass (see class LongHaulFlight)

                // Do the LongHaulFlight class and this command after all the basic functionality is working for regular flights

            }

            // Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)

          // This one is done for you as a guide for other commands

            else if (action.equalsIgnoreCase("SEATS"))

            {

                String flightNum = null;

                if (commandLine.hasNext())

                {

                    flightNum = commandLine.next();

                    if (manager.seatsAvailable(flightNum))

                    {

                        System.out.println("Seats are available");

                    }

                    else

                    {

                        System.out.println(manager.getErrorMessage());

                    }

                }

            }

            // Cancel an existing reservation (example input: cancel AC220)

            else if (action.equalsIgnoreCase("CANCEL"))

            {
            	
            	System.out.print("Enter the Flight Number");
            	 String inputFlightNumber=null;
            	 if(scanner.hasNext())
                     inputFlightNumber = scanner.next();
                    	System.out.println("Flight Number Entered  "+inputFlightNumber);
                // call cancelReservation() method in manager passing in the flight number string
                    myReservations = manager.cancelReservation(inputFlightNumber);

                // A reference to a Reservation object is returned. Check to make sure it is not == null
                    if(myReservations==null)
                    	manager.getErrorMessage();// If it is null, then call manager.getErrorMessage() and print the message
                    else
                    	System.out.println("Cancellation done");// If it is not null, add the reservation to the myReservations array list and print the reservation (see class Reservation)
                
            }

      // Print all the reservations in array list myReservations

            else if (action.equalsIgnoreCase("MYRES"))

            {

                manager.myReservationsList();

            }

            // Print the list of aircraft (see class Manager)

            else if (action.equalsIgnoreCase("CRAFT"))

          {

              manager.printAllAircraft();

            }

            // These commands can be left until we study Java interfaces

            // Feel free to implement the code in class Manager if you already understand interface Comparable

            // and interface Comparator

            else if (action.equalsIgnoreCase("SORTCRAFT"))

          {

            manager.sortAircraft();

          }

          else if (action.equalsIgnoreCase("SORTBYDEP"))

          {

              manager.sortByDeparture();


          }

          else if (action.equalsIgnoreCase("SORTBYDUR"))

          {

              manager.sortByDuration();

          }
      

            System.out.print("\n>");

        }

    }

    

}

