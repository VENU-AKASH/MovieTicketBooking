package movieticketbooking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Movie movie = new Movie(
                "Avengers",
                "Action",
                4.5
        );

        Booking booking = new Booking();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     MOVIE TICKET BOOKING");
            System.out.println("================================");

            System.out.println("1. Show Movie Details");
            System.out.println("2. Show Available Seats");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Rate Movie");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

            case 1:

                movie.displayMovieDetails();
                break;

            case 2:

                booking.displaySeats();
                break;

            case 3:

                System.out.print("Enter seat number: ");
                int seatNumber = scanner.nextInt();

                System.out.print("Enter coupon (MOVIE10 / MOVIE20 / NONE): ");
                String coupon = scanner.next();

                booking.bookSeat(seatNumber, coupon);
                break;

            case 4:

                System.out.print("Enter seat number to cancel: ");
                int cancelSeat = scanner.nextInt();

                booking.cancelSeat(cancelSeat);
                break;

            case 5:

                System.out.print("Enter your rating (1-5): ");
                double newRating = scanner.nextDouble();

                movie.rateMovie(newRating);
                break;

            case 6:

                System.out.println("Thank you for using Movie Ticket Booking!");
                System.out.println("Have a great day!");
                break;

            default:

                System.out.println("Invalid choice!");
        }

        } while (choice != 6);

        scanner.close();
    }
}