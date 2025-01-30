package katas.exercises;

import katas.exercises.movieRental.Rental;
import katas.exercises.movieRental.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovieRentalCustomerTest {

    private MovieRentalCustomer customer;
    private Movie regularMovie;
    private Movie newReleaseMovie;
    private Movie childrensMovie;
    private Rental regularRental;
    private Rental newReleaseRental;
    private Rental childrensRental;

    @Test
    public void test() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }
    @Test
    public void testHtmlStatement() {
        customer = new MovieRentalCustomer("Martin");

        regularMovie = new Movie("Ran", Movie.REGULAR);
        newReleaseMovie = new Movie("Trois Couleurs: Bleu", Movie.NEW_RELEASE);
        childrensMovie = new Movie("Toy Story", Movie.CHILDRENS);

        regularRental = new Rental(regularMovie, 3);
        newReleaseRental = new Rental(newReleaseMovie, 2);
        childrensRental = new Rental(childrensMovie, 4);

        customer.addRental(regularRental);
        customer.addRental(newReleaseRental);
        customer.addRental(childrensRental);
        String expected = "<h1>Rental Record for <em>Martin</em></h1>\n" +
                "<table>\n" +
                "<tr><td>Ran</td><td>3.5</td></tr>\n" +
                "<tr><td>Trois Couleurs: Bleu</td><td>6.0</td></tr>\n" +
                "<tr><td>Toy Story</td><td>3.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>12.5</em></p>\n" +
                "<p>You earned <em>4</em> frequent renter points</p>\n";
        assertEquals(expected, customer.htmlStatement());
    }
}
