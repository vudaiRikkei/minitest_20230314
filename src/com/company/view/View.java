package com.company.view;

import com.company.model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);
    public void showListStudent(Student[] students){
        System.out.println(Arrays.deepToString(students));
    }
    public Student getInfoStudent(){
        scanner.nextLine();
        System.out.println("tên sv");
        String name = scanner.nextLine();
        System.out.println("tuổi: ");
        int age = scanner.nextInt();
        return new Student(name, age);
    }

   public int getIdEdit(){
       System.out.println("nhập id học viên cần sửa ");
       return scanner.nextInt();
   }

    public int getIdDelete(){
        System.out.println("nhập id student cần delete: ");
        return scanner.nextInt();
    }
}
