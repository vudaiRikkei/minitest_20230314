package com.company.navBar;

import com.company.model.Student;
import com.company.view.View;

import java.util.Scanner;

public class NavBar {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];
        students[0] = new Student(1, "dai", 21);
        students[1] = new Student(2, "dai1", 22);
        students[2] = new Student(3, "dai2", 23);
        View view = new View();
        int choice = 0;
        do {
            System.out.println("***************STUDENT MANAGE***************************\n" +
                    "1.\tShow List Student.\n" +
                    "2.\tCreate Student\n" +
                    "3.\tUpdate Student\n" +
                    "4.\tDelete Student\n" +
                    "5.\tSort Student By Age ASC \n" +
                    "0.\t exit \n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: view.showListStudent(students);
                    break;
                case 2: students = view.addStudent(students);
                    break;
                case 3: view.editStudent(students);
                    break;
                case 4: students = view.delete(students);
                    break;
                case 5:students = view.shortByAge(students);
                    break;
            }
        } while (choice != 0);
    }
}
