package dto;

import java.util.ArrayList;
import java.util.List;

public class ReservationInfoSetDto {

	public List<ReservationInfoSetItem> reservations;
	public int size;
	
	public ReservationInfoSetDto() {
		this.reservations = new ArrayList<>();
		this.size = 0;
	}
	public void addReservationItem(ReservationInfoSetItem reservationItem) {
			this.reservations.add(reservationItem);
	}
	public void addSize(int count) {
		size += count;
	}
	public void setReservations(List<ReservationInfoSetItem> reservations) {
		if (reservations == null) 
			this.reservations = null;
		else 
			this.reservations.addAll(reservations);
	}
}
