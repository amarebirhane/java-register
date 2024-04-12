/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondyear;
import java.util.*;
/**
 *
 * @author aman
 */
import java.io.Serializable;

public class Grading implements Serializable {
   private Student student;
    private List<AnyCourse> courses11;
    private List <AnyCourse> courses12;
    private List<AnyCourse>  courses21;
    private List<AnyCourse> courses22;
    private List<AnyCourse> courses31;
    private List<AnyCourse> courses32;
    private List<AnyCourse> courses41;
    private List<AnyCourse> courses42;
    private List<AnyCourse> courses51;
    private List<AnyCourse> courses52;
    public Grading(Student student) {
        this.student=student;
        ManageCourse manage=new ManageCourse();
        List<AnyCourse> courseList=manage.desrialize();
        DisplayDetail dd=new DisplayDetail();
        if(student.getStudentYear()==1&&student.getStudentSemister()==1){
            this.courses11=dd.searchCourseByYearAndSemister(courseList, 1, 1);
        }
        else if(student.getStudentYear()==1&&student.getStudentSemister()==2){
            this.courses12=dd.searchCourseByYearAndSemister(courseList, 1, 2);
        }
        else if(student.getStudentYear()==2&&student.getStudentSemister()==1){
            this.courses21=dd.searchCourseByYearAndSemister(courseList, 2, 2);
        }
        else if(student.getStudentYear()==2&&student.getStudentSemister()==2){
            this.courses22=dd.searchCourseByYearAndSemister(courseList, 2, 2);
        }
        else if(student.getStudentYear()==3&&student.getStudentSemister()==1){
            this.courses31=dd.searchCourseByYearAndSemister(courseList, 3, 1);
        }
        else if(student.getStudentYear()==3&&student.getStudentSemister()==2){
            this.courses32=dd.searchCourseByYearAndSemister(courseList, 3, 2);
        }
        else if(student.getStudentYear()==4&&student.getStudentSemister()==1){
            this.courses41=dd.searchCourseByYearAndSemister(courseList, 4, 1);
        }
        else if(student.getStudentYear()==4&&student.getStudentSemister()==2){
            this.courses42=dd.searchCourseByYearAndSemister(courseList, 4, 2);
        }
        else if(student.getStudentYear()==5&&student.getStudentSemister()==1){
            this.courses51=dd.searchCourseByYearAndSemister(courseList, 5, 1);
        }
        else if(student.getStudentYear()==5&&student.getStudentSemister()==2){
            this.courses52=dd.searchCourseByYearAndSemister(courseList, 5, 2);
        }
    }
public List<AnyCourse> getSemisterCourses(){
if(student.getStudentYear()==1&&student.getStudentSemister()==1){
return courses11;
}
else if(student.getStudentYear()==1&&student.getStudentSemister()==2){
    return courses12;
    }
    else if(student.getStudentYear()==2&&student.getStudentSemister()==1){
        return courses21;
        }
        else if(student.getStudentYear()==2&&student.getStudentSemister()==2){
            return courses22;
            }
            else if(student.getStudentYear()==3&&student.getStudentSemister()==1){
                return courses31;
                }
                else if(student.getStudentYear()==3&&student.getStudentSemister()==2){
                    return courses32;
                    }
                    else if(student.getStudentYear()==4&&student.getStudentSemister()==1){
                        return courses41;
                        }
                        else if(student.getStudentYear()==4&&student.getStudentSemister()==2){
                            return courses42;
                            }
             else if(student.getStudentYear()==5&&student.getStudentSemister()==1){
                                return courses51;
                                }
              else if(student.getStudentYear()==5&&student.getStudentSemister()==2){
                                    return courses52;
                                    }
return null;
}
public List<AnyCourse> getSemisterCourses(int year,int semister){
    if(year==1&&semister==1){
    return courses11;
    }
    else if(year==1&&semister==2){
        return courses12;
        }
        else if(year==2&&semister==1){
            return courses21;
            }
            else if(year==2&&semister==2){
                return courses22;
                }
             else if(year==3&&semister==1){
                    return courses31;
                    }
            else if(year==3&&semister==2){
                        return courses32;
                        }
            else if(year==3&&semister==2){
                            return courses32;
                            }
             else if(year==4&&semister==1){
                                return courses41;
                                }
             else if(year==4&&semister==2){
                                    return courses42;
                                    }
                else if(year==5&&semister==1){
                                        return courses51;
                                        }
                 else if(year==5&&semister==2){
                                            return courses52;
                                            }
    return null;
    }
public void setSemisterCourses(){
    ManageCourse manage=new ManageCourse();
    List<AnyCourse> courseList=manage.desrialize();
    DisplayDetail dd=new DisplayDetail();
    if(student.getStudentYear()==1&&student.getStudentSemister()==1){
        this.courses11=dd.searchCourseByYearAndSemister(courseList, 1, 1);
    }
    else if(student.getStudentYear()==1&&student.getStudentSemister()==2){
        this.courses12=dd.searchCourseByYearAndSemister(courseList, 1, 2);
    }
    else if(student.getStudentYear()==2&&student.getStudentSemister()==1){
        this.courses21=dd.searchCourseByYearAndSemister(courseList, 2, 1);
    }
    else if(student.getStudentYear()==2&&student.getStudentSemister()==2){
        this.courses22=dd.searchCourseByYearAndSemister(courseList, 2, 2);
    }
    else if(student.getStudentYear()==3&&student.getStudentSemister()==1){
        this.courses31=dd.searchCourseByYearAndSemister(courseList, 3, 1);
    }
    else if(student.getStudentYear()==3&&student.getStudentSemister()==2){
        this.courses32=dd.searchCourseByYearAndSemister(courseList, 3, 2);
    }
    else if(student.getStudentYear()==4&&student.getStudentSemister()==1){
        this.courses41=dd.searchCourseByYearAndSemister(courseList, 4, 1);
    }
    else if(student.getStudentYear()==4&&student.getStudentSemister()==2){
        this.courses42=dd.searchCourseByYearAndSemister(courseList, 4, 2);
    }
    else if(student.getStudentYear()==5&&student.getStudentSemister()==1){
        this.courses51=dd.searchCourseByYearAndSemister(courseList, 5, 1);
    }
    else if(student.getStudentYear()==5&&student.getStudentSemister()==2){
        this.courses52=dd.searchCourseByYearAndSemister(courseList, 5, 2);
    }
}
public void assignCourse(){
    if(student.getStudentYear()==1&&student.getStudentSemister()==1){
        toAll(courses11);
    }
    else if(student.getStudentYear()==1&&student.getStudentSemister()==2){
        toAll(courses12);
    }
    else if(student.getStudentYear()==2&&student.getStudentSemister()==1){
        toAll(courses21);
    }
    else if(student.getStudentYear()==2&&student.getStudentSemister()==2){
        toAll(courses22);
    }
    else if(student.getStudentYear()==3&&student.getStudentSemister()==1){
        toAll(courses31);
    }
    else if(student.getStudentYear()==3&&student.getStudentSemister()==2){
        toAll(courses32);
    }
    else if(student.getStudentYear()==4&&student.getStudentSemister()==1){
        toAll(courses41);
    }
    else if(student.getStudentYear()==4&&student.getStudentSemister()==2){
        toAll(courses42);
    }
    else if(student.getStudentYear()==5&&student.getStudentSemister()==1){
        toAll(courses51);
    }
    else if(student.getStudentYear()==5&&student.getStudentSemister()==2){
        toAll(courses52);
    }
}
   
public void toAll(List<AnyCourse> semisterCourses){
    if(semisterCourses!=null){
        System.out.println("*********score submission*************");
        System.out.println("Sutdnet Id: "+student.getStudentId());
        System.out.println("Student Name: "+student.getStudentName());
        System.out.println("Year: "+student.getStudentYear());
        System.out.println("Semisetr: "+student.getStudentSemister());
        scoreInput(semisterCourses);
    }
}
public void scoreInput(List<AnyCourse> semisterCourses){
    for (AnyCourse course : semisterCourses) {
       double score=scoreMenu(course.getCourseName());
       if(score>0){
        course.addStudentScore(score);
       }
}
}
public double scoreMenu(String name){
    System.out.print("\n enter score out of 100 for "+name+" course:");
    Scanner scanner=new Scanner(System.in);
    double score=scanner.nextDouble();
    return score;

}
    public void addScore(Course course,double score) {
        course.addStudentScore(score);
    }
   
    // Other methods for grading operations
    public double calculateCGPA(){
       return getTotalSemisterPoints(student.getStudentYear()
       ,student.getStudentSemister())/
       getTotalSemisterCredits(student.getStudentYear(),student.getStudentSemister());
    }
    public double calculateCGPA(int year,int semister){
        return getTotalSemisterPoints(year,semister)/
       getTotalSemisterCredits(year,semister);
    }
    public double calculateGPA(int year,int semister){
        return getTotalPoints(year,semister)/getTotalCredits(year,semister);
    }
    public   void setStudent(Student student){
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }
    public double getTotalSemisterPoints(int year,int semister){
        if(year==1&&semister==1){
            return toAllPoints(courses11);
        }
        else if(year==1&&semister==2){
            return toAllPoints(courses12);
        }
        else{
            return 0;
        }
        
    }
    public int getTotalSemisterCredits(int year,int semister){
        if(year==1&&semister==1){
            return toAllCredits(courses11);
        }
        else if(year==1&&semister==2){
            return toAllCredits(courses12);
        }
        else{
            return 0;
        }
    }
    public double getTotalPoints(int year,int semister){
        if(year==1&&semister==1){
            return toAllPoints(courses11);
        }
        else if(year==1&&semister==2){
            return toAllPoints(courses11)+toAllPoints(courses12);
        }
        return toAllPoints(courses11)+toAllPoints(courses12);
    }
    public int getTotalCredits(int year,int semister){
        if(year==1&&semister==1){
            return toAllCredits(courses11);
        }
        else if(year==1&&semister==2){
            return toAllCredits(courses11)+toAllCredits(courses12);
        }
        return toAllCredits(courses11)+toAllCredits(courses12);
    }
    
    public int toAllCredits(List<AnyCourse> semisterCourses){
        int totalCredits=0;
        for(AnyCourse course:semisterCourses){
            totalCredits+=course.getCreditHour();
        }
        return totalCredits;
    
    }

    public double toAllPoints(List<AnyCourse> semisterCourses){
        double totalPoints=0;
        for(AnyCourse course:semisterCourses){
            totalPoints+=course.getPoints();
        }
        return totalPoints;

    }
}
