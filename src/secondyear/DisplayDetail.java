package secondyear;

import java.util.ArrayList;
import java.util.List;

public class DisplayDetail {
      public static void displayGradingList(List<Grading> gradingList,String sid) {
        if (gradingList != null) {
            for (Grading grading : gradingList) {
                if(grading.getStudent().getStudentId().equals(sid)){
                displayEachGrade(grading);
                return;
                }
               }
               System.out.println("no student exists with student id: "+sid);
        }
        else {
            System.out.println("No Grading objects found in the file.");
        } 
    }
    public static void displayStudentList(List<Grading> gradingList){
        System.out.printf("%-20s", "Student Id");
        System.out.printf("%-30s", "Student Name");
        System.out.printf("%-20s", "Student Gender");
        System.out.printf("%-15s", "Student Year");
        System.out.printf("%-15s", "Student Semister");
        System.out.println("\n*********************************************************************************************************");
        if (gradingList != null) {
            for (Grading grading : gradingList) {
                displayEachStudent(grading);
               }
        }
        else {
            System.out.println("No Grading objects found in the file.");
        } 

    }
    public static void displayEachGrade(Grading grading){
        Student student=grading.getStudent();
        System.out.printf("Student Id: %-20s%n", student.getStudentId());
        System.out.printf("Student Name: %-20s%n", student.getStudentName());
        System.out.printf("Student Gender: %-20s%n", student.getStudentGender());
        System.out.printf("Student Year: %-20s%n", student.getStudentYear());
        System.out.printf("Student Semister: %-20s%n", student.getStudentSemister());
        System.out.println();
        System.out.printf("%-10s %-50s %-10s %-10s %-15s %-10s%n", "Course Code", "Course Name", "Score", "Grade", "Credit Hour", "Points");
        System.out.println("===========================================================================================================================");
        List<AnyCourse> semisterCourses=grading.getSemisterCourses(1,1);
        displayAnySemister(semisterCourses, grading,1,1);

        semisterCourses=grading.getSemisterCourses(1,2);
        displayAnySemister(semisterCourses, grading,1,2);

        semisterCourses=grading.getSemisterCourses(2,1);
        displayAnySemister(semisterCourses, grading,2,1);

        semisterCourses=grading.getSemisterCourses(2,2);
        displayAnySemister(semisterCourses, grading,2,2);

        semisterCourses=grading.getSemisterCourses(3,1);
        displayAnySemister(semisterCourses, grading,3,1);

        semisterCourses=grading.getSemisterCourses(3,2);
        displayAnySemister(semisterCourses, grading,3,2);

        semisterCourses=grading.getSemisterCourses(4,1);
        displayAnySemister(semisterCourses, grading,4,1);

        semisterCourses=grading.getSemisterCourses(4,2);
        displayAnySemister(semisterCourses, grading,4,2);

        semisterCourses=grading.getSemisterCourses(5,1);
        displayAnySemister(semisterCourses, grading,5,1);

        semisterCourses=grading.getSemisterCourses(5,2);
        displayAnySemister(semisterCourses, grading,5,2);
    }
    public static void displayAnySemister(List<AnyCourse> semisterCourses,Grading grading,int year,int semister){
        Student student=grading.getStudent();
        if(semisterCourses!=null){
            for(AnyCourse course:semisterCourses){
                displayGradeCourse(course);
            }
        
            System.out.println();
            
            // Use printf to format the output with a fixed precision and sign
            System.out.printf("Total  Semister points: %10.2f%n"
            , grading.getTotalSemisterPoints(year,semister));
            System.out.printf("Total Semister Credits: %6d%n", 
            grading.getTotalSemisterCredits(year,semister));
            System.out.printf("Semister CGPA: %18.2f%n", grading.calculateCGPA(year,semister));
            System.out.println();
            System.out.printf("Total  points: %10.2f%n"
            , grading.getTotalPoints(year,semister));
            System.out.printf("Total  Credits: %6d%n", 
            grading.getTotalCredits(year,semister));
            System.out.printf("Accumulative GPA: %18.2f%n", grading.calculateGPA(year,semister));
            System.out.println("--------------------------\n\n");
        }

    }
    public static void displayEachStudent(Grading grading){
        
                Student student=grading.getStudent();
                // Use printf to format the output with a fixed width and alignment
                System.out.printf("%-20s", student.getStudentId());
                System.out.printf("%-30s", student.getStudentName());
                System.out.printf("%-20s", student.getStudentGender());
                System.out.printf("%-15s", student.getStudentYear());
                System.out.printf("%-15s", student.getStudentSemister());
                System.out.println();
                // Use printf to format the output with a table-like structure
            }
            public static void searchById(List<Grading> gradingList,String id){
                if (gradingList != null) {

                    for (Grading grading : gradingList) {
                        //System.out.println(grading.getStudent().getStudentId());
                       if((grading.getStudent().getStudentId()).equals(id)){
                        displayEachGrade(grading);
                        return;
                       }
                }
                System.out.println("Student with id: "+id+" does not exist!");
            }
                else {
                    System.out.println("No Grading objects found in the file.");
                } 
            }
            public static void displayGradeCourse(AnyCourse course){
                System.out.printf("%-10s %-50s %-10.2f %-10s %-15d %-10.2f%n",
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getScore(),
                        course.getGrade(),
                        course.getCreditHour(), 
                        course.getPoints());
            }
            public static void displayCourse(AnyCourse course){
                System.out.printf("%-10s %-50s %-10d %-10d %-10d %n"
                ,course.getCourseCode(),
                course.getCourseName(),
                course.getyear(),
                course.getSemister(),
                course.getCreditHour());
                
                System.out.println();
                
            }
            public static void displayCoursesList(List<AnyCourse> courseList) {
                if (courseList != null) {
                    System.out.printf("%-10s %-50s %-10s %-10s %-10s %n", "Course Code", "Course Name", "Year", "Semister", "Credit Hour");
                    System.out.println("===========================================================================================================================");
                    System.out.println();
                    for (AnyCourse course : courseList) {
                        displayCourse(course);
                       }
                }
                else {
                    System.out.println("No Course objects found in the file.");
                } 
            }


            public static void displayCourseByCode(List<AnyCourse> courseList,String code){
                if (courseList != null) {
                    System.out.printf("%-10s %-50s %-10s %-10s %-10s %n", "Course Code", "Course Name", "Year", "Semister", "Credit Hour");
                    System.out.println("===========================================================================================================================");
                    System.out.println();

                    for (AnyCourse course : courseList) {
                        //System.out.println(grading.getStudent().getStudentId());
                       if(course.getCourseCode().equals(code)){
                        displayCourse(course);
                       }
                }
                System.out.println("Course with course code: "+code+" does not exist!");
            }
                else {
                    System.out.println("No Course objects found in the file.");
                } 
            }


            public  List<AnyCourse> searchCourseByYearAndSemister(List<AnyCourse> courseList,int year,int semister){
                List<AnyCourse> semisterCourses=new ArrayList<AnyCourse>();
                if (courseList != null) {
                  

                    for (AnyCourse course : courseList) {
                        //System.out.println(grading.getStudent().getStudentId());
                       if(course.getyear()==year&&course.getSemister()==semister){
                        semisterCourses.add(course);
                       }
                }
              return semisterCourses ;
            }
                else {
                    System.out.println("No Course objects found in the file.");
                    return semisterCourses;
                } 
            }
}
