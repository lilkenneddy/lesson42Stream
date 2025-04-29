package org.example;

import org.example.lesson42Stream.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Mark", 3.9, 18);
        Student student2 = new Student("Danya", 4.1, 21);
        Student student3 = new Student("Vova", 4.0, 20);
        Student student4 = new Student("Rostik", 5.0, 85);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        studentList.stream()
                .filter(n -> n.getGrade() < 4.0)
                .forEach(System.out::println);

        Optional<Student> bestStudent = studentList.stream()
                .max(Comparator.comparingDouble(Student::getGrade));
        bestStudent.ifPresent(System.out::println);

        long count = studentList.stream()
                .filter(n -> n.getAge() > 20)
                .count();
        System.out.println(count);

        List<Student> sortedListOfStudents = studentList.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedListOfStudents);

        boolean hasMaxGrade = studentList.stream()
                .anyMatch(n -> n.getGrade() == 5.0);
        System.out.println(hasMaxGrade);

        studentList.stream()
                .filter(n -> n.getGrade() > 4.0)
                .forEach(n -> System.out.println(n.getName()));

    }
}