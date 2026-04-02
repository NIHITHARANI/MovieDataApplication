package model;

import java.time.LocalDateTime;
import java.util.List;

public class StoredMovie {

    private String movieId;
    private String title;
    private String releaseDate;
    private String overview;
    private double rating;
    private List<Genre> genres;
    private String storedAt;
    private String source;

    public StoredMovie(Movie movie) {
        this.movieId = movie.getMovieId();
        this.title = movie.getTitle();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.rating = movie.getRating();
        this.genres = movie.getGenres();
        this.source = source;
        this.storedAt = LocalDateTime.now().toString();
    }

    public String getMovieId() { return movieId; }

    @Override
    public String toString() {
        return "StoredMovies{" +
                "id='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", genres=" + genres +
                ", storedAt='" + storedAt + '\'' +
                '}';
    }
}

