package entitites;

import java.time.Duration;
import java.time.LocalDate;

import aplication.Program;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	
	public Integer duration() {
		Duration time = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
		int timeDuration = (int) time.toDays();
		return timeDuration;
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.now();
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (checkout.isBefore(checkin)) {
			return "Error in reservation update: Check-out date must be after check-in date";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: Room " + roomNumber);
		sb.append(", check-in: " + checkin.format(Program.fmt));
		sb.append(", check-out: " + checkout.format(Program.fmt));
		sb.append(", " + duration() + " nights");
		return sb.toString();
	}
 }
