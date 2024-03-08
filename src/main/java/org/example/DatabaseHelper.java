package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/web_app";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    public void addBuyer(Buyer buyer) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO buyers (name, email) VALUES (?, ?)")) {
            stmt.setString(1, buyer.getName());
            stmt.setString(2, buyer.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBuyer(Buyer buyer) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE buyers SET name=?, email=? WHERE id=?")) {
            stmt.setString(1, buyer.getName());
            stmt.setString(2, buyer.getEmail());
            stmt.setInt(3, buyer.getBuyerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBuyer(int id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM buyers WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Buyer> getAllBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM buyers")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                buyers.add(new Buyer(id, name, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyers;
    }

    public void addProduct(Product product) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)")) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE products SET name=?, price=? WHERE id=?")) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getProductId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addSale(Sale sale) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO sales (product_id, buyer_id, quantity) VALUES (?, ?, ?)")) {
            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getBuyerId());
            stmt.setInt(3, sale.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSale(Sale sale) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE sales SET product_id=?, buyer_id=?, quantity=? WHERE id=?")) {
            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getBuyerId());
            stmt.setInt(3, sale.getQuantity());
            stmt.setInt(4, sale.getProductId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSale(int id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM sales WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sales")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int buyerId = rs.getInt("buyer_id");
                int quantity = rs.getInt("quantity");
                sales.add(new Sale(id, productId, buyerId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

}
