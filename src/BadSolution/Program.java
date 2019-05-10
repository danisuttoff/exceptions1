package BadSolution;
////https://github.com/acenelio/exceptions1-java
//solução anteriot era muito ruim porque as validações estavam na app, o certo é saporra tá na classe Reservation,
// porque dai migoo se ta delegando a loógica pra classe certa morow ,é nóis parça!

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Program {
    public static void main(String[]args) throws ParseException {
        Date now = new Date();
        Scanner in  = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room number");
        int number = in.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(in.next());
        System.out.println("Check-out date (dd/MM/yyyy)");
        Date checkOut = sdf.parse(in.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after Check-in date");
        }

        else if(checkIn.before(now) ||checkOut.before(now)) {
            System.out.println( "Error in reservation: Reservation dates for update must be future dates");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(in.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(in.next());


            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }
            in.close();

    }
}
