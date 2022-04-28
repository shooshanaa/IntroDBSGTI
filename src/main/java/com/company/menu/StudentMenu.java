package com.company.menu;

import com.company.controllers.StudentController;

import java.util.Scanner;

public class StudentMenu {

    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do? ");
        System.out.println("1. Add a new student");
        System.out.println("2. Get student by ID");
        System.out.println("3. Edit student data");
        System.out.println("4. Add student scores");
        System.out.println("5. Delete student");
        System.out.println("6. Delete scores");
        System.out.println("7. Edit scores");


        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                System.out.println(StudentController.addStudent() ? "Successfully added new student" : "Student not added");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 3:
                StudentController.editStudent();
                break;
            case 4:
                System.out.println(StudentController.addStudentScores() ? "Added successfully" : "Scores not added");
                break;
            case 5:
                StudentController.deleteStudent();
                break;
            case 6:
                System.out.println(StudentController.deleteScore()? "Scores deleted" : "Scores not deleted");
                break;
            case 7:
                StudentController.editScore();
                break;
            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }

    }
}
