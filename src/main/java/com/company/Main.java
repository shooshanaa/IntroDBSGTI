package com.company;
import com.company.books.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);

        try {
            scanner.nextInt();
        } catch (Exception e){
            System.out.println("the value entered is not a string");
        }*/

        List<Books> books = new ArrayList<>();

        books.add(new Books(1, "Jayne Eyre", 4f));
        books.add(new Books(2, "Black Beauty", 9f));
        books.add(new Books(3, "Game of Thrones", 7f));
        books.add(new Books(4, "The Great Expectations", 5f));
        books.add(new Books(5, "Winnie the Pooh", 12f));

        for (int i = 0; i < books.size(); i++) {
            if (books.getPrice() >= 5) {
                System.out.println(books.getName() + " costs " + books.getPrice() + " which is more than 5$");
            }

        }





    }

}
