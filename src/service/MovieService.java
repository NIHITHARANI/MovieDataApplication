package service;

import model.*;
import repository.*;
import exception.*;

import java.util.*;

public class MovieService {

    private MovieRepository movieRepo;
    private GenreRepository genreRepo;
    private StoredMovieRepository storageRepo;

    public MovieService(MovieRepository m, GenreRepository g, StoredMovieRepository s) {
        this.movieRepo = m;
        this.genreRepo = g;
        this.storageRepo = s;
    }

    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

    public void addGenre(Genre genre) {
        genreRepo.save(genre);
    }

    public void assignGenre(String movieId, String genreId) {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        Genre genre = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        movie.addGenre(genre);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    public List<Movie> filterByGenre(String genreName) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movieRepo.findAll()) {
            for (Genre g : m.getGenres()) {
                if (g.getName().equalsIgnoreCase(genreName)) {
                    result.add(m);
                }
            }
        }
        if(result.isEmpty())
            System.out.println("No movies with this genre found.");
        return result;
    }

    public void storeMovie(String movieId) throws DuplicateMovieException {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        if (storageRepo.exists(movieId)) {
            throw new DuplicateMovieException("Already stored!");
        }

        storageRepo.save(new StoredMovie(movie));
    }

    public void displayAllMovies() {
        for(Movie movie:movieRepo.findAll())
            System.out.println(movie);
    }

    public void displayStoredMovies() {
        storageRepo.findAll().forEach(System.out::println);
    }
}
