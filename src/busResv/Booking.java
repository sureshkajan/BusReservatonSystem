package busResv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    private final boolean bookings;
    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner key=new Scanner(System.in);
        System.out.println("Enter name of passenger:");
        passengerName=key.next();
        System.out.println("Enter bus no:");
        busNo=key.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput=key.next();

        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

        try{
            date=dateFormat.parse(dateInput);
        }catch(ParseException e){
            e.printStackTrace();
        }

        public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses){
            int capacity=0;
            for(Bus bus:buses){
                if(bus.getBusNo()==busNo){
                    capacity=bus.getCapacity();
                }
            }
            int booked=0;

            for(Booking b:bookings){
                if(b.busNo==busNo && b.date.equals(date)){
                    booked++;
                }
            }

            return booked<capacity?true:false;
        }
    }



}
