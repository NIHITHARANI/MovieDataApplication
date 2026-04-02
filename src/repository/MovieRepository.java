package repository;

import model.Movie;
import java.util.*;

public class MovieRepository {

    private Map<String, Movie> movieMap = new HashMap<>();

    public void save(Movie movie) {
        movieMap.put(movie.getMovieId(), movie);
    }

    public Optional<Movie> findById(String id) {
        return Optional.ofNullable(movieMap.get(id));
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movieMap.values());
    }

    public List<Movie> findByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movieMap.values()) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(m);
            }
        }
        if(result.isEmpty())
            System.out.println("No movie found with this title: "+title);
        return result;
    }
}

