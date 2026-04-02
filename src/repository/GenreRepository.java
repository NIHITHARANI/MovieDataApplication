package repository;

import model.Genre;
import java.util.*;

public class GenreRepository {

    private Map<String, Genre> genreMap = new HashMap<>();

    public void save(Genre genre) {
        genreMap.put(genre.getGenreId(), genre);
    }

    public Optional<Genre> findById(String id) {
        return Optional.ofNullable(genreMap.get(id));
    }
}
