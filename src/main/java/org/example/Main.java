package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.createTables();

        }
    }



/*import com.mysql.cj.jdbc.Driver;

public class Main {
    public static void main(String[] args) {
        String version = Driver.class.getPackage().getImplementationVersion();
        System.out.println("MySQL JDBC Driver Version: " + version);
    }
}
*/

