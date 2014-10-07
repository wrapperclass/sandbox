package com.nelson.dpatterns.creational.factory;

/**
 * The Connection object in the java package sql is a factory. Depending on the database driver you use you get
 * the database vendors implementation of the Statement interface. In the following example we actually get an
 * OracleStatement object from the package oracle.jdbc.driver when calling createStatement.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnectionFactoryUsage {
    static Connection con;
    static Statement stmt;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("myServer", "user", "password");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
