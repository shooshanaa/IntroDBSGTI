package com.company.controllers;

import com.company.objects.Authors;
import com.company.objects.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DBConnection.getConnection;

public class AuthorController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addAuthor() {
        System.out.println("Enter the author's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the author's age: ");
        int age = scanner.nextInt();
        try {
            ps = getConnection().prepareStatement("INSERT INTO authors(name, age) VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }
    public static Authors getAuthorById(){
        System.out.println("Enter the id of the author: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM authors WHERE id=" + id);
            rs = ps.executeQuery();

            int authorsId;
            int age;
            String name;

            Authors author = new Authors();


            while (rs.next()){
                authorsId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                author.setName(name);
                author.setId(authorsId);
                author.setAge(age);
            }
            return author;


        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean deleteAuthor(){
        System.out.println("Enter the id of the author you want to delete: ");
        int id = scanner.nextInt();


        try {
            ps = getConnection().prepareStatement("DELETE FROM authors WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }

    }
}
