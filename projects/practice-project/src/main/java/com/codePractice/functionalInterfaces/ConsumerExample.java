package com.codePractice.functionalInterfaces;

import com.codePractice.data.Student;
import com.codePractice.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
  static Consumer<Student> c2=(student)->System.out.println(student);
    static Consumer<Student> c3=(student)->System.out.print(student.getName());
   static Consumer<Student> c4=(student)->System.out.println(student.getActivities());
    public static void printStudent(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printNameActivites(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4));// consumer chaining

    }

    public static void printNameActivitesUsingCondition(){
        List<Student> studentList = StudentDataBase.getAllStudents();
       studentList.forEach(student -> {
           if (student.getGpa()>=3){
               c3.andThen(c4).accept(student);
           }
       });
    }
    public static void main(String[] args) {
        Consumer<String> c1 = (s)->System.out.println(s.toUpperCase());
        c1.accept("java8");
        printStudent();
        printNameActivites();
        printNameActivitesUsingCondition();

    }
}

