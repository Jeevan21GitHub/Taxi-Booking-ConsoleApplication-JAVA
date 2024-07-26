package taxibooking.com;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	private static int customerId;
	public static ArrayList<ArrayList<String>>taxiList=new ArrayList<ArrayList<String>>();
	public static int count=0;
	public void bookingTaxi(char pickupPoint, char dropPoint, int pickupTime,Taxi[]taxi) {
		int minDis=Integer.MAX_VALUE;
		int taxiIndex=-1;
		for(int i=0;i<4;i++) {
			int distance=Math.abs(taxi[i].getDropPoint()-pickupPoint);
			int freeTime=taxi[i].getNextFreeTime()+distance;
			if(distance<minDis && freeTime<=pickupTime) {
				minDis=Math.abs(taxi[i].getDropPoint()-pickupPoint);
				taxiIndex=i;
			}
			else if(distance==minDis && freeTime<=pickupTime ) {
				if(taxi[i].getEarnings()<taxi[taxiIndex].getEarnings()) {
					taxiIndex=i;
				}
				
			}
			
		}
		if(taxiIndex!=-1) {
			taxi[taxiIndex].setPickupPoint(pickupPoint);
			taxi[taxiIndex].setDropPoint(dropPoint);
			int nextFreeTime=Math.abs(pickupPoint-dropPoint)+pickupTime;
			taxi[taxiIndex].setNextFreeTime(nextFreeTime);
			customerId++;
			int distance=Math.abs(pickupPoint-dropPoint);
			float earnings=100+(((15*distance)-5)*10);
			taxi[taxiIndex].setEarnings(earnings);
			taxi[taxiIndex].setTotalEarnings(earnings+taxi[taxiIndex].getTotalEarnings());
			taxi[taxiIndex].setPickupTime(pickupTime);
			taxi[taxiIndex].setBookingId(customerId);
//			add to the taxi List
			String data=customerId+"\t\t"+customerId+"\t\t"+pickupPoint+"\t\t"+dropPoint+"\t\t\t"+pickupTime+"\t\t"+nextFreeTime+"\t\t"+earnings;
			if(count<4) {
				taxiList.add(new ArrayList<>());
				count++;
			}
			taxiList.get(taxiIndex).add(data);
			System.out.println("Taxi-"+(taxiIndex+1)+" is Booked");
		}
		else {
			System.out.println("No Taxi is free");
			System.exit(0);
		}
		
	}
	public void displayTaxiFreeTime(Taxi[]taxi) {
		int count=1;
		System.out.println("----------------------------");
		System.out.println("| Taxi No | Available Time |");
		System.out.println("----------------------------");
		for(Taxi t:taxi) {
			System.out.println("| Taxi-"+count+": |     "+t.getNextFreeTime()+"          |");
			count++;
		}
		System.out.println("----------------------------");
	}
	public void displayTaxiDetails(Taxi[]taxi) {
		System.out.println("BookingID\tCustomerId\tFrom\tTo\tPickupTime\tDropTime\tAmount");
		for(int i=0;i<taxiList.size();i++) {
			System.out.println("Taxi:"+(i+1)+" Total Earning:"+taxi[i].getTotalEarnings());
			for(int j=0;j<taxiList.get(i).size();j++) {
				System.out.println(taxiList.get(i).get(j));
			}
		}
	}

}
