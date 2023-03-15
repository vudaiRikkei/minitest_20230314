package com.company.view;

import com.company.model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);
    public void showListStudent(Student[] students){
        System.out.println(Arrays.deepToString(students));
    }
    public Student createStudent(Student[] students){
        System.out.println("tên sv");
        String name = scanner.next();
        System.out.println("tuổi: ");
        int age = scanner.nextInt();
        return new Student(students[students.length-1].getId()+1, name, age);
    }

    public Student[] addStudent(Student[] students){
        Student[] studentsNew = new Student[students.length+1];
        for (int i = 0; i < students.length; i++) {
            studentsNew[i] = students[i];
        }
            studentsNew[students.length] = createStudent(students);
            return studentsNew;
    }

    public void editStudent(Student[] students){
        showListStudent(students);
        System.out.println("nhập id học viên cần sửa ");
        int idEdit = scanner.nextInt();
        int indexEdit = getIndexStdById(students, idEdit);
        System.out.println("tên sv");
        String name = scanner.next();
        System.out.println("tuổi: ");
        int age = scanner.nextInt();
        students[indexEdit].setName(name);
        students[indexEdit].setAge(age);
    }

    public int getIndexStdById(Student[] students, int id){
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id){
                return i;
            }
        }
        return -1;
    }
    public Student[] delete(Student[] students){
        Student[] newStudents = new Student[students.length-1];
        System.out.println("nhập id student cần edit: ");
        int deleteId = scanner.nextInt();
        int indexdelete = getIndexStdById(students, deleteId);
        for (int i = 0; i < newStudents.length; i++) {
            if (i < indexdelete){
                newStudents[i] = students[i];
            }else newStudents[i] = students[i+1];
        }
        return newStudents;
    }

    public Student[] shortByAge(Student[] students){
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
}
