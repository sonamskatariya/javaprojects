package fileoperations;

import java.util.Scanner;
import java.io.*;

class TicketClass {

	public void readFile() {
		FileReader file = null;
		try {
			file = new FileReader("tickets.txt");
			Scanner sc = new Scanner(file);
			double sum = 0;
			int totalEntries = 0;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				// spit the line on , char
				String[] data = line.split(",");
				// Important : assuming price is always at index 1 parse and use value
				sum = sum + Double.parseDouble(data[1].trim());
				totalEntries = totalEntries + 1;
			}
			sc.close();
			System.out.println("Total Price : " + sum);
			System.out.println("Average Price per Ticket : " + sum / totalEntries);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
	}

	public static void main(String[] args) {
		TicketClass ticketClass = new TicketClass();
		ticketClass.readFile();

	}
}
