package hotelManagementSystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		Scanner sc = new Scanner(System.in);
		int ch, ch2;
		char wish;
		int roomNumber;
		do {
			System.out.println(
					"\nEnter your choice :\n1.Display room Type \n2.Features \n3.Book \n4.Order food\n5.Booking Details\n6.Checkout\n7.Exit\n");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("\n1.Single Room \n2.Double Room \n3.Deluxe Room\n");
				break;
			case 2:
				System.out.println("\nChoose room type :\n1.Single Room \n2.Double Room \n3.Deluxe Room\n");
				ch2 = sc.nextInt();
				hotel.features(ch2);
				break;
			case 3:
				System.out.println("\nChoose room type :\n1.Single Room \n2.Double Room \n3.Deluxe Room\n");
				ch2 = sc.nextInt();
				hotel.book(ch2);
				break;
			case 4:
				hotel.order();
				break;
			case 5:
				hotel.printData();
				break;
			case 6:
				System.out.println("\nEnter the Room Number to be Checkout");
				roomNumber = sc.nextInt();
				hotel.checkout(roomNumber);
				break;
			case 7:
				break;

			}

			System.out.println("\nContinue : (y/n)");
			wish = sc.next().charAt(0);
			if (!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')) {
				System.out.println("Invalid Option");
				System.out.println("\nContinue : (y/n)");
				wish = sc.next().charAt(0);
			}
		} while (wish == 'y' || wish == 'Y');
	}

}