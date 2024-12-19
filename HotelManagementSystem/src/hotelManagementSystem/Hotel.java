package hotelManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel extends HotelBookingDetails {

    static Scanner sc = new Scanner(System.in);
    Map<Integer,String> bookingDetails = new HashMap<>();
    int singleRoomNumber=100;
    int doubleRoomNumber=200;
    int deluxRoomNumber=300;
     public void book(int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        int age;
        String lunch;
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
          }
          else {
        
          switch (rn) {
            case 1:Singleroom sr=new Singleroom(name,contact,gender);
            	   bookingDetails.put(singleRoomNumber++, name);
                   System.out.println("\n\nYour Single Room is booked with below Details");
                   System.out.println(sr.toString());
            		break;
            case 2:
            	System.out.print("\nEnter customer2 name: ");
                name2 = sc.next();
                System.out.print("Enter contact number: ");
                contact2=sc.next();
                System.out.print("Enter gender: ");
                gender2 = sc.next();
                Doubleroom dr=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                bookingDetails.put(doubleRoomNumber++, name);
                System.out.println("\n\nYour Double Room is booked with below Details");
                System.out.println(dr.toString());
                break;
            case 3:
                System.out.print("Enter Lunch Type : ");
                lunch=sc.next();
            	Deluxroom dlr=new Deluxroom(name,contact,gender,lunch);
            	 bookingDetails.put(deluxRoomNumber++, name);
            	System.out.println("\n\nYour Delux Room is booked with below Details");
            	 System.out.println(dlr.toString());
            	System.out.println("\n\nYour have choose Lunch type as"+dlr.getLunch());
                break;
            default:System.out.println("Wrong option");
                break;
        }
       }
    }
    
   public void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1000 ");
                break;
            case 2:System.out.println("Number of double beds : 2\nAC : No\nFree breakfast : Yes\nCharge per day:2000  ");
                break;
            case 3:System.out.println("Number of delux beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000  ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
   @Override
    public void order()
    {
        int i,quantity;
        float price = 0;
        float total=0;
        char wish;
        ArrayList<String>foodOrder=new ArrayList<String>();
             System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity- ");
            quantity=sc.nextInt();
           
			switch(i)
            {
                case 1:
                	foodOrder.add("Sandwich");
                	price=quantity*50;
                    break;
                case 2:
                	foodOrder.add("Pasta");
                	price=quantity*60;
                    break;
                case 3:
                	foodOrder.add("Noodles");
                	price=quantity*70;
                    break;
                case 4:
                	foodOrder.add("Coke");
                	price=quantity*30;
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
			total = total+price;
            System.out.println("Do you want to order anything else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y'); 
        System.out.println("Your food Order is  ");
        for (int i1 = 0; i1 < foodOrder.size();i1++) 
	      { 		      
	          System.out.println(foodOrder.get(i1)); 		
	      }   
        System.out.println("Your Total Price  "+total);
        }

	@Override
	public void printData() {
		
		System.out.println("Total Bookings in hotel: " + bookingDetails.size());
		System.out.println("Detail Booking Log as below");
		
		// Iterate over all bookingDetails, using the keySet method.
		System.out.println("Room Number - Customer Name");
		for (Integer key : bookingDetails.keySet())
            System.out.println(key + " - " + bookingDetails.get(key));
        System.out.println();
	}

	public void checkout(int roomNumber) {
        
        if (bookingDetails.containsKey(roomNumber)) {
        	System.out.println("Your Booking Details \n"+roomNumber + " - " + bookingDetails.get(roomNumber));
        	bookingDetails.remove(roomNumber);
        	System.out.println("\n You have successfully Checkout");
        	System.out.println("Updated Total Bookings in hotel: " + bookingDetails.size());
        }else {
        	System.out.println("\n Enter valid room number");	
        }
        
		
		
	}
    }
