package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> lastNames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "developer");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT last_name, first_name FROM students"))
        {
            while (resultSet.next())
            {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");

                System.out.printf("%s%n", firstName);
                lastNames.add(lastName);
            }

            System.out.printf("%s%n", lastNames);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}