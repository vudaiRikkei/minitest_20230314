package com.company.navBar;

import com.company.model.Student;
import com.company.view.View;

import java.util.Scanner;

public class NavBar {

    static View view = new View();

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
                case 1:
                    view.showListStudent(students);
                    break;
                case 2:
                    students = addStudent(students);
                    break;
                case 3:
                    editStudent(students);
                    break;
                case 4:
                    students = delete(students);
                    break;
                case 5:
                    shortByAge(students);
                    break;
            }
        } while (choice != 0);
    }

    static public Student[] addStudent(Student[] students) {
        Student[] studentsNew = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            studentsNew[i] = students[i];
        }
        studentsNew[students.length] = view.getInfoStudent();
        studentsNew[students.length].setId(students[students.length - 1].getId() + 1);
        return studentsNew;
    }

    static public Student[] delete(Student[] students) {
        Student[] newStudents = new Student[students.length - 1];
        int indexdelete = getIndexStdById(students, view.getIdDelete());
        for (int i = 0; i < newStudents.length; i++) {
            if (i < indexdelete) {
                newStudents[i] = students[i];
            } else newStudents[i] = students[i + 1];
        }
        return newStudents;
    }

    static public Student[] shortByAge(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < students.length; j++)
                if (students[j].getAge() < students[min_idx].getAge())
                    min_idx = j;
            Student temp = students[min_idx];
            students[min_idx] = students[i];
            students[i] = temp;
        }
        return students;
    }

    static public int getIndexStdById(Student[] students, int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    static public void editStudent(Student[] students) {
        view.showListStudent(students);
        int idEdit = view.getIdEdit();
        Student student = view.getInfoStudent();
        int indexEdit = getIndexStdById(students, idEdit);
        students[indexEdit].setName(student.getName());
        students[indexEdit].setAge(student.getAge());
    }
}
