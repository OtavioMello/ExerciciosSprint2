package br.com.aula.compasso;

import br.com.aula.compasso.dao.ProductDAO;
import br.com.aula.compasso.factory.ConnectionFactory;
import br.com.aula.compasso.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        //Creating new products with Product() constructors.
        Product productOne = new Product("Garrafa", "Garrafa Termica 2L", 25, 65.00);
        Product productTwo = new Product("Pote", "Pote Roxo Grande", 10, 39.90);
        Product productThree = new Product("Prato", "Prato Porcelana Fundo", 2, 49.90);

        //Creating a connection with the DB.
        try(Connection connection = new ConnectionFactory().recoverConnection()){

            //Creating a ProductDAO reference to get class methods.
            ProductDAO productDAO = new ProductDAO(connection);


            //boolean var that keep the menu's loop.
            boolean menu = true;
            Scanner scanner = new Scanner(System.in);

            do{
                System.out.println("\n=========( Welcome )=========\n" +
                        "      SELECT AN OPTION:      \n" +
                        "1 -> Auto-register Products\n" +
                        "2 -> Update the 1st Product\n" +
                        "3 -> Delete the 2nd Product\n" +
                        "0 -> Exit\n" +
                        "==============()==============\n");

                String inputMenu = scanner.nextLine();

                switch (inputMenu){

                    case "1":

                        //Calling the reset method to drop and create a new empty table.
                        productDAO.resetTable();

                        //Registering products in the DB.
                        productDAO.register(productOne);
                        productDAO.register(productTwo);
                        productDAO.register(productThree);
                        break;

                    case "2":

                        //Updating the 1st product in the DB.
                        productDAO.update();
                        break;

                    case "3":

                        //Deleting the 2nd product in the DB.
                        productDAO.delete();
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
