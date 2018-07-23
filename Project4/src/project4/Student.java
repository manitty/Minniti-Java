//File name: Student.java
//Author: Paul Minniti
//Date: 5 March 2017
//This programming project involves writing a program to manage a student database
package project4;
import java.text.DecimalFormat;

public class Student {
  //Instance Variables
   private String name;
   private String major;
   private double credits;
   private double points;
  
   //default constructor
   public Student() {
       name = "Name";
       major = "Major";
       credits = 0;
       points = 0;
   }
  
   // constructor
   public Student(String name, String major) {
       this.name = name;
       this.major = major;
       credits = 0;
       points = 0;
   }
  
   // courseCompleted method calculates students gpa
   public void courseCompleted(String grade, int hours) {
       credits += hours;
      
       switch(grade.toLowerCase().charAt(0)) {
           case 'a':
               points += 4 * hours;
               break;
           case 'b':
               points += 3 * hours;
               break;
           case 'c':
               points += 2 * hours;
               break;
           case 'd':
               points += hours;
               break;
           default:
               break;
       }
   } 
  
 //toString method 
   @Override
   public String toString() {
       // format gpa to two decimal places
       DecimalFormat formatter = new DecimalFormat("#0.00");
       // default gpa
       String gpa = "4.0";
       // calculate gpa
       if(credits > 0) {
           gpa = formatter.format(points / credits);
       }
      
       // string to return
       String studentInfo = "Name: " + name +
               "\nMajor: " + major + "\nGPA: " + gpa;
       // returns student's information as a String
       return studentInfo;
   }
}