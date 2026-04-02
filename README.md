## Movie Data Application

## Name: Nihitha Rani.B
## Reg no: 212223040131

## Description

In this project, students will build a CLI tool that fetches movie data from APIs like TMDb. Users can search movies, filter by genre, or view trending films using terminal commands. The application will store movie data locally, support filtering, and avoid duplicates. This project helps students understand how backend systems serve data even without a frontend UI.

## ER Diagram

<img width="883" height="681" alt="image" src="https://github.com/user-attachments/assets/351e5683-db1a-4063-800a-de3b68665587" />

## Outline

model:
   ->Movie
   ->Genre
   ->StoredMovie

repository:
  ->MovieRepository
  ->GenreRepository
  ->StoredMovieRepository

service:
  ->MovieService

main.java

## Workflow


1️⃣ Data Initialization
The system starts by loading predefined movie and genre data.
Movies and genres are stored using in-memory data structures (HashMap) for fast access.

2️⃣ User Interaction (CLI)
The user interacts through a menu-driven interface:
Search movie by title
Filter movies by genre
Store a movie
Display all movies
Display stored movies

3️⃣ Search Operation
User enters a movie title.
The system performs a case-insensitive search.
Matching movies are retrieved from the repository and displayed.

4️⃣ Filter by Genre
User enters a genre name.
The system iterates through all movies and returns those containing the selected genre.
Demonstrates many-to-many relationship handling.


5️⃣ Store Movie (Core Feature)
✔ Steps:
The system checks if the movie exists in the repository.
If not found → throws MovieNotFoundException.
If already stored → throws DuplicateMovieException.
Otherwise:
Creates a StoredMovie object (snapshot of full movie details)
Saves it in storage using a HashMap (O(1) lookup)
✔ Purpose:
Simulates caching or persistence layer
Prevents duplicate entries

6️⃣ Display Operations
All Movies → Displays complete movie list with genres
Stored Movies → Displays only cached/stored movies







