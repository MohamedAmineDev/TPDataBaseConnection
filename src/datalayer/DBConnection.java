package datalayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
public class DBConnection {
    private static String url = "jdbc:postgresql://localhost:5432/companydb";
    private static String userName = "companyuser";
    private static String password = "mmmmm";

    public static Connection getDbConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established !");
            connection.close();
            return connection;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
