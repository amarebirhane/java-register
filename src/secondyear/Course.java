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

public abstract class Course implements Serializable {
    private String courseCode;
    private String courseName;
   private double score;
   private String grade;
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

  public abstract double getPoints();
   public  void addStudentScore(double score){
         if(score>0){
             this.score=score;
             setGrade();
         }
     }
   
      public void setGrade(){
         if(score>=90){this.grade="A+";}
         else if(score>=85){this.grade="A";}
         else if(score>=80){this.grade="A-";}
         else if(score>=75){this.grade="B+";}
         else if(score>=70){this.grade="B";}
         else if(score>=65){this.grade="B-";}
         else if(score>=60){this.grade="C+";}
         else if(score>=55){this.grade="C";}
         else if(score>=50){this.grade="C-";}
         else if(score>=40){this.grade="D";}
         else{this.grade="F";}
         
     }
       public String getGrade(){return grade;}
       
   
  public void setCourseName(String courseName){this.courseName=courseName;}
  public void setCourseCode(String courseCode){this.courseCode=courseCode;}
  public String getCourseName(){return courseName;}
  public String getCourseCode(){return courseCode;}
  public double getScore(){return score;}
    // Other common methods for Course
}
