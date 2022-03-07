package datalayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
public class DBConnection {
    private static String url = "jdbc:postgresql://localhost:5432/companydb";
    private static String userName = "companyuser";
    private static String password = "mmmmm";
    private static Connection connection;

    public static Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established !");
            return connection;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static void closeConnetion() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
            System.out.println("The connection is closed !");
        } else {
            System.out.println("The connection is already closed !");
        }
    }

    public static void createTableEmployee() {
        ///step 1 : establish connection
        Connection connection = getDbConnection();
        ///step 2 : write the sql request
        String request = "create table employee(" +
                "id bigint primary key," +
                "name varchar not null," +
                "birthdate date," +
                "salary real," +
                "hire_date date," +
                "manager_id int null" +
                ")";
        ///step 3 : create statement
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(request);
            ///step 4: Execute the request
            int n = preparedStatement.executeUpdate();
            System.out.println("The table has been created !");
            closeConnetion();
        } catch (SQLException exception) {
            System.out.println("The table was not created !");
            System.out.println(exception.getMessage());
        }

    }
}
