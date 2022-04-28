package com.company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DBConnection.getConnection;
import com.company.objects.Student;

import javax.sound.midi.Soundbank;

public class StudentController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addStudent() {
        System.out.println("Enter the name of the student: ");
        String name = scanner.next();
        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();
        try {
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }
    public static Student getStudentById(){
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            int studentId, age;
            String name;

            Student student = new Student();



            while (rs.next()){
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(studentId);
                student.setAge(age);
            }
            return student;


        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void editStudent(){
        System.out.println("Enter the ID of the student: ");
        int id = scanner.nextInt();

        System.out.println("What field would you like to edit? (name, age) ");
        String fieldToEdit = scanner.next();

        System.out.println("What value do you want to enter? ");
        String update = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE students SET " + fieldToEdit + " = '" + update + "' WHERE id=" + id);
            ps.execute();
            System.out.println("Successfully updated student data");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteStudent(){
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM students WHERE id = " + id);
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean addStudentScores(){
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        System.out.println("Enter the mathematics score of the student: ");
        int math = scanner.nextInt();

        System.out.println("Enter the English score of the student: ");
        int eng = scanner.nextInt();

        System.out.println("Enter the Physics score of the student: ");
        int physics = scanner.nextInt();

        System.out.println("Enter the Chemistry score of the student: ");
        int chemistry = scanner.nextInt();


        try {
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid, mathematics, english, physics, chemistry) VALUES(" + id + ", " + math + ", " + eng + ", "+ physics + ", "+ chemistry +")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

    public static boolean deleteScore(){
        System.out.println("Enter the id of the student: ");
        int studentid = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE id = " + studentid);
            ps.execute();
            return true;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public static void deleteScore(int id){

        try {
            ps = getConnection().prepareStatement(("DELETE FROM scores WHERE id = " + id) && ("DELETE FROM students WHERE id = studentid " + studentid));
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();

        }

    }
*/
    public static void editScore() {
        System.out.println("Enter the ID of the student: ");
        int studentid = scanner.nextInt();

        System.out.println("What field would you like to edit? (mathematics, English, physics, chemistry) ");
        String fieldToEdit = scanner.next();

        System.out.println("What value do you want to enter? ");
        String update = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE scores SET " + fieldToEdit + " = '" + update + "' WHERE id=" + studentid);
            ps.execute();
            System.out.println("Successfully updated scores");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
