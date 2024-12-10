package com.codePractice.streams_terminal;

import com.codePractice.data.Student;
import com.codePractice.data.StudentDataBase;

import static java.util.stream.Collectors.*;

public class StreamsSumAvgExample {
    public static Integer sum(){
       return StudentDataBase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNoteBooks));
    }
    public static double avg(){
        return  StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println("total no of note books: " +sum());
        System.out.println("average: "+avg());
    }
}
                                     