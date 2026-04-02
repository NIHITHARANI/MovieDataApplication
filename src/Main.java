import model.*;
import repository.*;
import service.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieService service = new MovieService(
                new MovieRepository(),
                new GenreRepository(),
                new StoredMovieRepository()
        );

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\tMovie Data Application");
        System.out.println("-------------------------------------------------------------------------------------------");

        // DATA
        service.addGenre(new Genre("1", "Action"));
        service.addGenre(new Genre("2", "Comedy"));
        service.addGenre(new Genre("3", "Drama"));
        service.addGenre(new Genre("4", "Sci-Fi"));
        service.addGenre(new Genre("5", "Thriller"));

        service.addMovie(new Movie("101", "Inception", "2010", "Sci-fi", 8.8, "2025"));
        service.addMovie(new Movie("102", "The Mask", "1994", "Comedy", 7.0, "2025"));
        service.addMovie(new Movie("103", "Interstellar", "2014", "Sci-fi", 8.7, "2025"));
        service.addMovie(new Movie("104", "Titanic", "1997", "Romantic Drama", 7.9, "2025"));
        service.addMovie(new Movie("105", "Avengers Endgame", "2019", "Superhero Action", 8.4, "2025"));
        service.addMovie(new Movie("106", "Joker", "2019", "Psychological Drama", 8.5, "2025"));
        service.addMovie(new Movie("107", "Deadpool", "2016", "Action Comedy", 8.0, "2025"));
        service.addMovie(new Movie("108", "The Hangover", "2009", "Comedy", 7.7, "2025"));
        service.addMovie(new Movie("109", "Parasite", "2019", "Thriller Drama", 8.6, "2025"));
        service.addMovie(new Movie("110", "The Matrix", "1999", "Sci-fi Action", 8.7, "2025"));
        service.addMovie(new Movie("111", "John Wick", "2014", "Action Thriller", 7.9, "2025"));
        service.addMovie(new Movie("112", "Gladiator", "2000", "Historical Drama", 8.5, "2025"));
        service.addMovie(new Movie("113", "Shutter Island", "2010", "Psychological Thriller", 8.2, "2025"));
        service.addMovie(new Movie("114", "Forrest Gump", "1994", "Drama", 8.8, "2025"));
        service.addMovie(new Movie("115", "Iron Man", "2008", "Action", 7.9, "2025"));
        service.addMovie(new Movie("116", "Doctor Strange", "2016", "Sci-fi Fantasy", 7.5, "2025"));
        service.addMovie(new Movie("117", "Get Out", "2017", "Horror Thriller", 7.7, "2025"));
        service.addMovie(new Movie("118", "Superbad", "2007", "Comedy", 7.6, "2025"));
        service.addMovie(new Movie("119", "The Prestige", "2006", "Mystery Drama", 8.5, "2025"));
        service.addMovie(new Movie("120", "Fight Club", "1999", "Drama", 8.8, "2025"));

        service.assignGenre("101", "4");
        service.assignGenre("102", "2");
        service.assignGenre("103", "4");
        service.assignGenre("104", "3");
        service.assignGenre("105", "1");
        service.assignGenre("106", "3");
        service.assignGenre("107", "2");
        service.assignGenre("108", "2");
        service.assignGenre("109", "5");
        service.assignGenre("110", "4");
        service.assignGenre("111", "1");
        service.assignGenre("112", "3");
        service.assignGenre("113", "5");
        service.assignGenre("114", "3");
        service.assignGenre("115", "1");
        service.assignGenre("116", "4");
        service.assignGenre("117", "5");
        service.assignGenre("118", "2");
        service.assignGenre("119", "3");
        service.assignGenre("120", "3");

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("\n1. Search Movie");
            System.out.println("2. Filter by Genre");
            System.out.println("3. Store Movie");
            System.out.println("4. Display All Movies");
            System.out.println("5. Display Stored Movies");
            System.out.println("6. Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Title: ");
                        service.searchByTitle(sc.nextLine()).forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Genre: ");
                        service.filterByGenre(sc.nextLine()).forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Movie ID: ");
                        service.storeMovie(sc.nextLine());
                        System.out.println("Stored!");
                        break;

                    case 4:
                        System.out.println("Displaying all movies\n");
                        service.displayAllMovies();
                        break;

                    case 5:
                        System.out.println("Displaying all stored movies\n");
                        service.displayStoredMovies();
                        break;

                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}