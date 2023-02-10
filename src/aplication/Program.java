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
		
		LocalDate now = LocalDate.now();
		
		System.out.println("\nEnter data to update the reservation: ");
		System.out.print("Check-in date (dd/mm/yyyy): ");
		checkin = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		checkout = LocalDate.parse(sc.next(), fmt);
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		} else if (checkout.isAfter(checkin)) {
			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
		} else {
			System.out.println("Error in reservation update: Check-out date must be after check-in date");
		}
		
		
		sc.close();
	}
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

}
