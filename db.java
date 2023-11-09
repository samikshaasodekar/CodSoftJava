/*
Course Database: Store course information, including course code, title,
description, capacity and schedule.
Student Database: Store student information, including student ID, name and
registered courses.
Course Listing: Display available courses with details and available slots.
Student Registration: Allow students to register for courses from the available
options.
Course Removal: Enable students to drop courses they have registered for.
*/

import java.util.*;

class Course {
    int courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    Set<Student> students;

    Course(String code, String title, String desc, int cap, String schedule) {
        courseCode = Integer.parseInt(code);
        this.title = title;
        description = desc;
        capacity = cap;
        this.schedule = schedule;
        students = new HashSet<>();
    }

    void addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            System.out.println(student.name + " has been added to " + title);
        } else {
            System.out.println("Sorry, " + title + " is full.");
        }
    }

    void removeStudent(Student student) {
        students.remove(student);
        System.out.println(student.name + " has been removed from " + title);
    }

    boolean isFull() {
        return students.size() >= capacity;
    }
}

class Student {
    String studentID;
    String name;
    Set<Course> registeredCourses;

    Student(String id, String name) {
        studentID = id;
        this.name = name;
        registeredCourses = new HashSet<>();
    }

    void registerCourse(Course course) {
        if (!course.isFull()) {
            course.addStudent(this);
            registeredCourses.add(course);
            System.out.println("You're in! You've registered for " + course.title);
        } else {
            System.out.println("Oops! " + course.title + " is full. You can't register for it.");
        }
    }

    void dropCourse(Course course) {
        course.removeStudent(this);
        registeredCourses.remove(course);
        System.out.println("You've dropped " + course.title);
    }
}

public class db {
    public static void main(String[] args) {
        Course algorithms = new Course("101", "Algorithms", "Learn about algorithms", 30, "Monday 10am");
        Course dataStructures = new Course("102", "Data Structures", "Learn about data structures", 25, "Wednesday 10am");

        Student alice = new Student("101", "Alice");
        Student bob = new Student("102", "Bob");

        alice.registerCourse(algorithms);
        alice.registerCourse(dataStructures);
        bob.registerCourse(algorithms);

        alice.dropCourse(dataStructures);
    }
}


