package ro.fasttrackit.curs20;

import java.sql.*;

public class NotSpringConnection {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam", "rfamro", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from clan");

            while (resultSet.next()) {
                System.out.print(resultSet.getString("description"));
                System.out.print(" : ");
                System.out.println(resultSet.getString("author"));
            }
        }
    }
}
