package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DATABASE_NAME = "web_app";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public void createTables() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {


                try (Statement statement = connection.createStatement()) {
                    // SQL queries to create tables
                    String[] sqlQueries = {
                            "CREATE TABLE buyers (buyer_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), phone VARCHAR(20));",
                            "CREATE TABLE products (product_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), price DECIMAL(10, 2), description TEXT, quantity_available INT);",
                            "CREATE TABLE sales (sale_id INT AUTO_INCREMENT PRIMARY KEY, buyer_id INT, product_id INT, quantity_sold INT, sale_date DATE, FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id), FOREIGN KEY (product_id) REFERENCES products(product_id));"
                    };

                    for (String sqlQuery : sqlQueries) {
                        statement.executeUpdate(sqlQuery);
                    }

                    System.out.println("Tables created successfully.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

