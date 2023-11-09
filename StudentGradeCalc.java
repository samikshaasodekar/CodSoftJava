/*
Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the users.
*/

import java.util.Scanner;

public class StudentGradeCalc {	
	
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
			
        System.out.print("enter student name: ");		
        String name = sc.nextLine();
        
        System.out.print("enter the number of subjects: ");
        int n = sc.nextInt();
        
        int[] marks = new int[n];  
        marksEntry(marks);
        
        // Ask if the student has taken the optional subject
        System.out.print("Has the student taken the optional subject? (yes/no): ");
        String response = sc.next();
        boolean hasOptionalSubject = response.equalsIgnoreCase("yes");
        
        // If the student has taken the optional subject, enter the grade
        int optionalSubjectMark = 0;
        if (hasOptionalSubject) {
            System.out.print("Enter the mark for the optional subject: ");
            optionalSubjectMark = sc.nextInt();
        }

        printReportCard(name, marks, n, hasOptionalSubject, optionalSubjectMark);
				
    }	
    
    static void marksEntry(int[] marks){
           for(int i=0; i<marks.length; i++)
           {
            System.out.print("enter mark for subject-"+(i+1)+": ");
            marks[i] = sc.nextInt();
           }	
        }
        
    static void printReportCard(String name, int[] marks, int n, boolean hasOptionalSubject, int optionalSubjectMark){
        System.out.println("\n-----------------------------------------------------------------");
        
        System.out.println("\t\t REPORT CARD");
        System.out.println("NAME: " + name);
        
        System.out.println("-------------------------------------------------------------------");

        System.out.println("  SUBJECT \t\t MARKS \t\t GRADE");
        
        System.out.println("-------------------------------------------------------------------");
        
        int total = 0;

        for(int i=0;i<marks.length;i++){
            System.out.println("Subject-" + (i+1) + "\t\t   "+marks[i] + "\t\t   " + getGrade(marks[i]));
            total = total + marks[i];
        }

        if (hasOptionalSubject) {
            System.out.println("Optional Subject\t   "+optionalSubjectMark + "\t\t   " + getGrade(optionalSubjectMark));
        }
        
        System.out.println("-------------------------------------------------------------------");
        
        float avg = ((float)total)/n;
        System.out.printf("TOTAL: %d \t  AVERAGE: %.2f \t  OVERALL GRADE: %s \n", total, avg, getGrade((int)avg));
        
        System.out.println("-------------------------------------------------------------------");
    }

    static String getGrade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else if (marks >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}

