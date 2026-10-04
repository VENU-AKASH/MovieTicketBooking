package movieticketbooking;

public class Movie {

    private String movieName;
    private String genre;
    private double rating;

    public Movie(String movieName, String genre, double rating) {
        this.movieName = movieName;
        this.genre = genre;
        this.rating = rating;
    }

    public void displayMovieDetails() {

        System.out.println("\n================================");
        System.out.println("          MOVIE DETAILS");
        System.out.println("================================");
        System.out.println("Movie  : " + movieName);
        System.out.println("Genre  : " + genre);
        System.out.println("Rating : " + rating + "/5");
        System.out.println("================================");
    }

    public void rateMovie(double newRating) {

        if (newRating < 1 || newRating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }

        rating = newRating;

        System.out.println("Thank you for rating the movie!");
        System.out.println("New Rating: " + rating + "/5");
    }
}