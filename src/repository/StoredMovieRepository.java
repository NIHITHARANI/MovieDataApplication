package repository;

import model.StoredMovie;
import java.util.*;

public class StoredMovieRepository {

    private Map<String, StoredMovie> storage = new HashMap<>();

    public void save(StoredMovie movie) {
        storage.put(movie.getMovieId(), movie);
    }

    public boolean exists(String movieId) {
        return storage.containsKey(movieId);
    }

    public List<StoredMovie> findAll() {
        if(storage.isEmpty())
            System.out.println("No movies are stored yet...!!");
        return new ArrayList<>(storage.values());
    }
}


