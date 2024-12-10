package com.codePractice.streams_terminal;

import com.codePractice.data.Student;
import com.codePractice.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class streamGroupByExample{
//    public static void groupStudentsByGender(){
//     Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
//                .stream()
//                .collect(Collectors.groupingBy(Student::getGender));
//        System.out.println(studentMap);
//    }

    public static void customizedGroupingBy(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student->Student.getGpa()>=3.8?"outstanding":"Average"));
        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1(){
       Map<Integer,Map<String, List<Student>>> studentMap=StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(Student->Student.getGpa()>=3.8?"outstanding":"Average")));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_2(){
        Map<Integer,Map<String, List<Student>>> studentMap=StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(Student->Student.getGpa()>=3.8?"outstanding":"Average")));
        System.out.println(studentMap);
    }

    public static void calculateToGap(){
       Map<Integer, Optional<Student>> studentMapOptional =StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println(studentMapOptional);
    }

    public static void main(String[] args) {
//       groupStudentsByGender();
//        customizedGroupingBy();
//        twoLevelGrouping_1();
        calculateToGap();
    }
}