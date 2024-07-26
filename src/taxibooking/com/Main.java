package taxibooking.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Taxi Creation
		Taxi[] taxi=new Taxi[4];
		for(int i=0;i<4;i++) {
			taxi[i]=new Taxi();
		}
		try {
			while(true) {
				
				System.out.println("Enter a choice");
				System.out.println("1.Booking Taxi");	
				System.out.println("2.All Taxi Details");
				System.out.println("3.Taxi free time deatails");
				System.out.println("4.Exit");	
				int choice=sc.nextInt();
				switch(choice) {
					case 1:{
						try {
							System.out.println("Enter a pickPoint(A, B, C, D, E)");
							char pickupPoint=sc.next().charAt(0);
							System.out.println("Enter a DropPoint(A, B, C, D, E)");
							char dropPoint=sc.next().charAt(0);
							System.out.println("Pickup Time");
							int pickupTime=sc.nextInt();
							Booking booking=new Booking();
							booking.bookingTaxi(pickupPoint,dropPoint,pickupTime,taxi);
						}
						catch (InputMismatchException e) {
							System.out.println("Input Mismatch!!! Please enter correct input");
						}
						catch (Exception e) {
							System.out.println("Error: "+e.getMessage());
						}
					}
					break;
					case 2:{
						Booking booking=new Booking();
						booking.displayTaxiDetails(taxi);
					}
					break;
					case 3:{
						Booking booking=new Booking();
						booking.displayTaxiFreeTime(taxi);
					}
					break;
					case 4:{
						System.out.println("Application Exited...");
						System.exit(0);
					}
					break;
					default:{
						System.out.println("Application Exited...");
						System.exit(0);
					}
				}
		}
		}
		catch (InputMismatchException e) {
			System.out.println("Input Mismatch!!! Please enter correct input");
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
			
}
	
	

