package br.com.aula.compasso.dao;

import br.com.aula.compasso.models.Product;

import java.sql.*;

public class ProductDAO {

    private Connection connection;

    //Constructor method.
    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    //Reset method, that drop and create a new empty table every time that the 1 option is called.
    public void resetTable() throws SQLException {

        //Statement that drop a table (if exists).
        try (PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS PRODUCT")) {

            preparedStatement.execute();
            System.out.println("\nTable deleted!");

        }

        //Statement that create a new table.
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("CREATE TABLE PRODUCT (PRODUCT_ID INT AUTO_INCREMENT PRIMARY KEY, PRODUCT_NAME VARCHAR(50) NOT NULL," +
                        " PRODUCT_DESCRIPTION VARCHAR(150) NOT NULL ,PRODUCT_AMOUNT INT NOT NULL," +
                        " PRODUCT_PRICE DECIMAL(9, 2) UNSIGNED NOT NULL)")) {

            preparedStatement.execute();
            System.out.println("A new table has been created!\n");

        }
    }

    //Register method, that register a new product in the table.
    public void register(Product product) throws SQLException {

        //Statement that insert a new product in the table.
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO PRODUCT (PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_AMOUNT, PRODUCT_PRICE)" +
                        " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setInt(3, product.getProductAmount());
            preparedStatement.setDouble(4, product.getProductPrice());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                while (resultSet.next()) {
                    product.setProductID(resultSet.getInt(1));
                }
            }

            //SOUT that print each new product that are created.
            System.out.println("\n==============================" +
                    "\nProduct created with: " +
                    "\nID - " + product.getProductID() +
                    "\nName - " + product.getProductName() +
                    "\nDescription - " + product.getProductDescription() +
                    "\nAmount - " + product.getProductAmount() +
                    "\nPrice - R$" + product.getProductPrice() +
                    "\n==============================");
        }
    }

    //Update method, that update the 1st product in the table.
    public void update() throws SQLException {

        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE PRODUCT SET PRODUCT_NAME = 'Copo', PRODUCT_DESCRIPTION = 'Copo 250ml', PRODUCT_AMOUNT = '50', " +
                        "PRODUCT_PRICE = '5.00' WHERE PRODUCT_ID = 1")){

            preparedStatement.execute();

            //Alert that the 1st product has been updated.
            System.out.println("\nThe 1st product has been updated!!!");
        }
    }

    //Delete method, that delete the 2nd product in the table.
    public void delete() throws SQLException {

        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_ID = 2")){

            preparedStatement.execute();

            //Alert that the 2nd product has been deleted.
            System.out.println("\nThe 2nd product has been deleted!!!");
        }
    }
}

