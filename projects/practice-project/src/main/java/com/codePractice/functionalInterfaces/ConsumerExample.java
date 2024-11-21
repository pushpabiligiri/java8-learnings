package com.codePractice.functionalInterfaces;

import com.codePractice.data.Student;
import com.codePractice.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void printStudent(){
        Consumer<Student> c2=(student)->{System.out.println(student);};
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s)->System.out.println(s.toUpperCase());
        c1.accept("java8");
        printStudent();
    }
}

