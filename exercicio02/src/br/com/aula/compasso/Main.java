package br.com.aula.compasso;

import br.com.aula.compasso.dao.MovieDAO;
import br.com.aula.compasso.factory.ConnectionFactory;
import br.com.aula.compasso.models.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static br.com.aula.compasso.models.Movie.movies;

public class Main {

    public static void main(String[] args) throws SQLException {

        //Creating a connection with the DB.
        try(Connection connection = new ConnectionFactory().recoverConnection()){

            //Creating a ProductDAO reference to get class methods.
            MovieDAO movieDAO = new MovieDAO(connection);

            //Calling the reset method to drop and create a new empty table.
            movieDAO.resetTable();

            //Creating the movies Array.
            Movie.createMovieArray();

            //Registering movies data from the Movie ArrayList in the DB.
            for (int i = 0; i < movies.size(); i++) {
                movieDAO.register(movies.get(i));
            }

            //boolean var that keep the menu's loop.
            boolean menu = true;
            Scanner scanner = new Scanner(System.in);

            do{
                System.out.println("\n=========( Welcome )=========\n" +
                        "      SELECT AN OPTION:      \n" +
                        "1 -> List Movies\n" +
                        "0 -> Exit\n" +
                        "==============()==============\n");

                //Getting the menu option.
                String inputMenu = scanner.nextLine();

                switch (inputMenu){

                    case "1":

                        //Getting the user input.
                        System.out.println("Select the Number of Movies: ");
                        int inputMoviePerPage = scanner.nextInt();
                        System.out.println("Select the Page Number: ");
                        int inputPageNumber = scanner.nextInt();
                        scanner.nextLine();

                        //Calling the list() method to list movies according to user input of amount of movies per page and page number to list.
                        movieDAO.list(inputMoviePerPage, inputPageNumber);
                        break;

                    case "0":

                        //If the exit option is selected, the exit message is displayed and menu's loop end.
                        System.out.println("\nExiting Option Selected\nExiting Program!!!");
                        menu = !menu;
                        break;

                    default:

                        //If an invalid option is selected, the error message is displayed.
                        System.out.println("\nInvalid Option");
                }

            }while(menu);
        }
    }
}
