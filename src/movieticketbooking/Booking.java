package movieticketbooking;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Booking {

    boolean[][] seats = new boolean[5][5];
    Scanner sc = new Scanner(System.in);

    // Display all seats
    public void displaySeats() {

        System.out.println("\nSeats:");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                int seatNumber = (i * 5) + j + 1;

                if (seats[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[" + seatNumber + "] ");
                }
            }

            System.out.println();
        }
    }

    // Book a seat
    public void bookSeat(int seatNumber, String coupon) {

        if (seatNumber < 1 || seatNumber > 25) {
            System.out.println("Invalid seat number!");
            return;
        }

        int row = (seatNumber - 1) / 5;
        int column = (seatNumber - 1) % 5;

        if (seats[row][column]) {
            System.out.println("Seat " + seatNumber + " is already booked!");
            return;
        }

        seats[row][column] = true;

        double price = 200;

        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();

        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            price = 250;
        }

        double discount = 0;

        if (coupon.equalsIgnoreCase("MOVIE10")) {
            discount = price * 10 / 100;
        } else if (coupon.equalsIgnoreCase("MOVIE20")) {
            discount = price * 20 / 100;
        } else if (coupon.equalsIgnoreCase("NONE")) {
            discount = 0;
        } else {
            System.out.println("Invalid coupon. No discount applied.");
        }

        double finalPrice = price - discount;

        System.out.println();
        System.out.println("========== TICKET ==========");
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Ticket Price: ₹" + price);
        System.out.println("Coupon      : " + coupon);
        System.out.println("Discount    : ₹" + discount);
        System.out.println("Final Price : ₹" + finalPrice);
        System.out.println("============================");
        System.out.println("Ticket booked successfully!");

        System.out.print("Rate the movie from 1 to 5: ");
        int rating = sc.nextInt();

        if (rating >= 1 && rating <= 5) {
            System.out.println("Rating saved: " + rating + "/5");
        } else {
            System.out.println("Invalid rating.");
        }
    }

    // Cancel a seat
    public void cancelSeat(int seatNumber) {

        if (seatNumber < 1 || seatNumber > 25) {
            System.out.println("Invalid seat number!");
            return;
        }

        int row = (seatNumber - 1) / 5;
        int column = (seatNumber - 1) % 5;

        if (seats[row][column]) {

            seats[row][column] = false;

            System.out.println(
                    "Seat " + seatNumber + " cancelled successfully!"
            );

        } else {
            System.out.println("Seat " + seatNumber + " is not booked!");
        }
    }
}

