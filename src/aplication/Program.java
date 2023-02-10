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
		
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), fmt);
		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		System.out.println(reservation);
		
		System.out.println("\nEnter data to update the reservation: ");
		System.out.print("Check-in date (dd/mm/yyyy): ");
		LocalDate checkinUpdate = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		LocalDate checkoutUpdate = LocalDate.parse(sc.next(), fmt);
		reservation.updateDates(checkinUpdate, checkoutUpdate);
		System.out.println(reservation);
		
		sc.close();
	}
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

}
