package model;

public class Genre {
    private String genreId;
    private String name;

    public Genre(String genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public String getGenreId() { return genreId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}