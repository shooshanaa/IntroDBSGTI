package com.company.menu;

import com.company.controllers.AuthorController;
import com.company.controllers.BookController;

import java.util.Scanner;

public class AuthorsMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do? ");
        System.out.println("1. Add a new author");
        System.out.println("2. Get author by ID");
        System.out.println("3. Delete an author");


        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                System.out.println(AuthorController.addAuthor() ? "Successfully added new author" : "Author not added");
                break;
            case 2:
                System.out.println(AuthorController.getAuthorById().getName());
                break;
            case 3:
                System.out.println(AuthorController.deleteAuthor() ? "Delete completed" : "Author is not deleted");
                break;

            default:
                System.out.println("Invalid option. Try again.");
               menu();

        }
    }
}
