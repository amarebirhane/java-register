/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondyear;

/**
 *
 * @author aman
 */
import java.io.Serializable;
public class Student implements Serializable {
    private String studentID;
    private String studentName;
    private int studentYear=1;
    private int studentSemister=1;
    private String studentGender;
    private int creditHoursEarned;
    private double pointsEarned;
    
  

    public Student(String studentID, String studentName, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGender = studentGender;
    }

  
   
    public double calculateGPA(){
        Grading grading=new Grading(this);
        return grading.calculateGPA(studentYear,studentSemister);
    };

    public double calculateCGPA(){
        Grading grading=new Grading(this);
        return grading.calculateCGPA();
    }
    
    public void setStudentId(String studentId){this.studentID=studentID;}
    public void setStudentName(String studentName){this.studentName=studentName;}
    public void setStudentYear(int studentYear){this.studentYear=studentYear;}
    public void setStudentGender(String studentGender){this.studentGender=studentGender;}

    public void setStudentSemister(int studentSemister){if(studentSemister==1||studentSemister==2){
        this.studentSemister=studentSemister;
    }}
    
    public String getStudentId(){return studentID;}
    public String getStudentName(){return studentName;}
    public int getStudentYear(){return studentYear;}
    public String getStudentGender(){return studentGender;}
    public int getStudentSemister(){return studentSemister;}
}
