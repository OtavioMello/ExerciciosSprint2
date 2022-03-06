package br.com.aula.compasso.models;

import java.util.ArrayList;

public class Movie {

    private Integer movieID;
    private String movieName;
    private String movieDescription;
    private int movieYear;
    public static ArrayList<Movie> movies = new ArrayList<>();

    //Constructor method.
    public Movie(String InputMovieName, String InputMovieDescription, int InputMovieYear) {

        this.movieName = InputMovieName;
        this.movieDescription = InputMovieDescription;
        this.movieYear = InputMovieYear;

    }

    //Getters and Setters
    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public int getMovieYear() {
        return movieYear;
    }

    //Method thar register the movie data in an ArrayList.
    public static void createMovieArray(){

        movies.add(new Movie("WALL - E", "Animação", 2008));
        movies.add(new Movie("Up - Altas Aventuras", "Animação", 2009));
        movies.add(new Movie("Soul", "Animação", 2020));
        movies.add(new Movie("Luca", "Animação", 2021));
        movies.add(new Movie("Procurando Dory", "Animação", 2016));
        movies.add(new Movie("Raya e O Último Dragão", "Animação", 2021));
        movies.add(new Movie("Shang-Chi e a Lenda dos Dez Anéis", "Ação", 2021));
        movies.add(new Movie("Vingadores Ultimato", "Ação", 2019));
        movies.add(new Movie("Capitão América - Soldado Invernal", "Ação", 2014));
        movies.add(new Movie("Capitão América - O Primeiro Vingador", "Ação", 2011));
        movies.add(new Movie("A Era do Gelo", "Animação", 2002));
        movies.add(new Movie("A Era do Gelo 2", "Animação", 2006));
        movies.add(new Movie("A Era do Gelo 3", "Animação", 2009));
        movies.add(new Movie("A Era do Gelo 4", "Animação", 2012));
        movies.add(new Movie("A Era do Gelo - O Big Bang", "Animação", 2016));
        movies.add(new Movie("Eternos", "Ação", 2021));
        movies.add(new Movie("Homem Aranha - De Volta ao Lar", "Ação", 2017));
        movies.add(new Movie("Homem Aranha - Longe do Lar", "Ação", 2019));
        movies.add(new Movie("Homem Aranha - Sem Volta para Casa", "Ação", 2021));
        movies.add(new Movie("Homem Aranha no Aranhaverso", "Animação", 2018));

    }
}
