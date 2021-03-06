package com.company.controllers;

import com.company.objects.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DBConnection.getConnection;

public class BookController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addBook() {
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the book: ");
        int price = scanner.nextInt();
        try {
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + name + "', " + price + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }
    public static Books getBookById(){
        System.out.println("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id=" + id);
            rs = ps.executeQuery();

            int bookId;
            int price;
            String name;

            Books books = new Books();



            while (rs.next()){
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                books.setName(name);
                books.setId(bookId);
                books.setPrice(price);
            }
            return books;


        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean deleteBook(){
        System.out.println("Enter the id of the book you want to delete: ");
        int id = scanner.nextInt();


        try {
            ps = getConnection().prepareStatement("DELETE FROM books WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }

    }

   public static void editBook() {

       System.out.println("Enter the ID of the book: ");
       int id = scanner.nextInt();

       System.out.println("What field would you like to edit? (name, price) ");
       String fieldToEdit = scanner.next();

       System.out.println("What value do you want to enter? ");
       String update = scanner.next();

       try {
           ps = getConnection().prepareStatement("UPDATE books SET " + fieldToEdit + " = '" + update + "' WHERE id=" + id);
           ps.execute();
           System.out.println("Successfully updated book data");

       } catch (Exception e) {
           e.printStackTrace();
       }



   }






}
