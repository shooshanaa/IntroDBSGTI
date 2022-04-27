package com.company;
import com.company.menu.BookMenu;
import com.company.menu.StudentMenu;

public class Main {
    public static void main(String[] args) {

       //DBConnection.getConnection();

        StudentMenu.menu();
        //BookMenu.menu();


    }
/*        Scanner scanner = new Scanner(System.in);

        try {
            scanner.nextInt();
        } catch (Exception e){
            System.out.println("the value entered is not a string");
        }*/

  /*      List<Books> books = new ArrayList<>();

        books.add(new Books(1, "Jayne Eyre", 4f));
        books.add(new Books(2, "Black Beauty", 9f));
        books.add(new Books(3, "Game of Thrones", 7f));
        books.add(new Books(4, "The Great Expectations", 5f));
        books.add(new Books(5, "Winnie the Pooh", 12f));

        System.out.println(filterLessThanFive());


    }

    public static List<String> filterLessThanFive(List<Books>books){
      //  books.removeIf(books -> books.getPrice()<5);
        //return books;

        List<String>bookNames = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getPrice() < 5) books.remove(books.get(i));
        }
        books.forEach(book -> bookNames.add(book.getName()));

        return bookNames;
        }*/




}
