package taxibooking.com;

public class Taxi {
	private static int taxiNo;
	private int bookingId;
	private char pickupPoint;
	private char dropPoint;
	private int nextFreeTime;
	private int pickupTime;
	private float earnings;
	private float totalEarnings;
	public Taxi() {
		this.pickupPoint='A';
		this.dropPoint='A';
		this.nextFreeTime=6;
	}
	public float getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(float totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public static int getTaxiNo() {
		return taxiNo;
	}
	public int getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}
	public static void setTaxiNo(int taxiNo) {
		Taxi.taxiNo = taxiNo;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId=bookingId;
	}
	public char getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public char getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}
	public int getNextFreeTime() {
		return nextFreeTime;
	}
	public void setNextFreeTime(int nextFreeTime) {
		this.nextFreeTime = nextFreeTime;
	}
	public float getEarnings() {
		return earnings;
	}
	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}
}
