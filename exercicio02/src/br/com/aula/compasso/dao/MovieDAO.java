package br.com.aula.compasso.dao;

import br.com.aula.compasso.models.Movie;

import java.sql.*;


public class MovieDAO {

    private Connection connection;

    //Constructor method.
    public MovieDAO(Connection connection){
        this.connection = connection;
    }

    //Reset method, that drop and create a new empty table when the program starts.
    public void resetTable() throws SQLException {

        //Statement that drop a table (if exists).
        try(PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS MOVIE");){
            preparedStatement.execute();
        }

        //Statement that create a new table.
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("CREATE TABLE MOVIE (MOVIE_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "MOVIE_NAME VARCHAR(50) NOT NULL, MOVIE_DESCRIPTION VARCHAR(200) NOT NULL, MOVIE_YEAR VARCHAR(4) NOT NULL);")){
            preparedStatement.execute();
        }
    }

    //Register method, that register a new movie in the table.
    public void register(Movie movie) throws SQLException {

        //Statement that insert a new product in the table.
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO MOVIE (MOVIE_NAME, MOVIE_DESCRIPTION, MOVIE_YEAR) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, movie.getMovieName());
            preparedStatement.setString(2, movie.getMovieDescription());
            preparedStatement.setString(3, movie.getMovieYear());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    movie.setMovieID(resultSet.getInt(1));
                }
            }
        }
    }

    //List method, that will receive the movie amount per page and the page number and display to the user.
    public void list( int inputMoviePerPage, int inputPageNumber) throws SQLException {

        //*******EM PORTUGUÊS PRA SER MAIS FÁCIL DE EXPLICAR*******
        //Serão selecionadas as páginas onde seus valores forem -> PosiçãoFilme entre ((NumeroPagina - 1) * FilmePorPagina + 1) E (NumeroPagina * FilmePorPagina);
        //Sendo NumeroPagina = 2 E FilmePorPagina = 5, temos:
        //(2 - 1) * 5 + 1 = 6 -> Posição Inicial.
        //Até (2 * 5) = 10 -> Posição Final.
        //Seram exibidos os filmes que suas posições pertencem à esse intervalo (incluido posição inicial/final).
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY MOVIE_ID) AS MOVIE_POSITION, MOVIE_ID, MOVIE_NAME, " +
                            "MOVIE_DESCRIPTION, MOVIE_YEAR FROM MOVIE) AS MOVIE_TABLE " +
                            "WHERE MOVIE_POSITION BETWEEN ((? - 1) * ? + 1) AND (? * ?) ORDER BY MOVIE_ID;")) {

            preparedStatement.setInt(1, inputPageNumber);
            preparedStatement.setInt(2, inputMoviePerPage);
            preparedStatement.setInt(3, inputPageNumber);
            preparedStatement.setInt(4, inputMoviePerPage);

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {

                    //SOUT that will display the movie data in the console.
                    System.out.println("\n============================================================================================================================================\n" +
                                "Movie Position: " + resultSet.getInt(1) +
                                " | Movie ID: " + resultSet.getInt(2) +
                                " | Movie Name: " + resultSet.getString(3) +
                                " | Movie Description: " + resultSet.getString(4) +
                                " | Movie Release Year: " + resultSet.getString(5) +
                                "\n============================================================================================================================================");
                }
            }
        }
    }
}


