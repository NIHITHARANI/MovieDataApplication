package model;

import java.util.*;

public class Movie {
    private String movieId;
    private String title;
    private String releaseDate;
    private String overview;
    private double rating;
    private List<Genre> genres = new ArrayList<>();

    public Movie(String movieId, String title, String releaseDate,
                 String overview, double rating, String addedDate) {
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.rating = rating;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public String getReleaseDate() { return releaseDate; }
    public String getOverview() { return overview; }
    public double getRating() { return rating; }
    public List<Genre> getGenres() { return genres; }

    public void addGenre(Genre genre) {
        if (!genres.contains(genre)) {
            genres.add(genre);
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", genres=" + genres +
                '}';
    }
}