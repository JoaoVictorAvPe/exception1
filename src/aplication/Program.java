package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entitites.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Reservation reservation = null;
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), fmt);
		if (checkout.isAfter(checkin)) {
			reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
		} else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		
		System.out.println("\nEnter data to update the reservation: ");
		System.out.print("Check-in date (dd/mm/yyyy): ");
		checkin = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		checkout = LocalDate.parse(sc.next(), fmt);
		String error = reservation.updateDates(checkin, checkout);
		if (error != null) {
			System.out.println(error);
		} else {
			System.out.println(reservation);
		}
		
		
		sc.close();
	}
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

}
