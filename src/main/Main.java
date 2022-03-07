package main;

import datalayer.DBConnection;
import models.Employee;

public class Main {
    public static void main(String[] args) {
        //Employee employee = new Employee();
        System.out.println("Hello world !");
        DBConnection.getDbConnection();
    }
}
