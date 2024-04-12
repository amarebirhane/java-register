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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradingSystem {

    private static final String FILE_PATH = "grading_data.ser";

    public static void main(String[] args) {
        System.out.println("\n\n***********************************\n");
    System.out.println("welcome to Grading System");
    System.out.println("\n*********************** ************");
        // Storing and displaying Grading object
        
        while (true){
            int n;
            System.out.print("\n\n enter 1 for student Mangment:");
            System.out.print("\n enter 2 to see Course Mangement:");
            System.out.print("\n enter 3 to Student and Course Management");
            System.out.print("\n enter 0 to exit:");
            n=menu();
            if(n==1){
                studentManagment();
            }
            else if(n==2){
                courseManagment();
            }
            else if(n==3){
                studentAndCourseManagement();
            }
            else if(n==0){
                break;
            }
            else{
                System.out.println("invalid input!");
                        }
        }
    
    }
    public static void studentManagment(){
        List<Grading> gradingList;
        int n;
    while(true){
         System.out.print("\n\n enter 1 for add student:");
    System.out.print("\n enter 2 to see students:");
    System.out.print("\n enter 3 to search indivdual student by id:");
    System.out.print("\n enter 4 to update student information:");
    System.out.print("\n enter 5 to delete student:");
    System.out.print("\n enter 6 to register student for the new semister:");
    System.out.print("\n enter 0 to quit!\n");
    n=menu();

    if(n==0){System.out.println("\nbye!");
        break;}
    else if(n==1){
         addStudent(studentInput());
    }
    else if(n==2){
        //serializeToFile(gradingList);
                // Displaying all Grading objects
                gradingList =desrialize();
        DisplayDetail.displayStudentList(gradingList);
    }
    else if(n==3){
        System.out.print("\n enter student id:");
        Scanner scanner=new Scanner(System.in);
        String id=scanner.nextLine();
        gradingList =desrialize();
        //serializeToFile(gradingList);
                // Displaying all Grading objects
        DisplayDetail.searchById(gradingList,id);
    }
    else if(n==4){
        gradingList = desrialize();
        updateStudent(gradingList);
    }
    else if (n == 5) {
        gradingList = desrialize();
        deleteStudent(gradingList);
    }
    else if(n==6){
        gradingList=desrialize();
        registerStudent(gradingList);
    }
    else{
        System.out.println("invalid input!");
    }
    }

    }
    public static void courseManagment(){
          int n;
          while(true){
            System.out.print("\n\n enter 1 to add course:");
            System.out.print("\n enter 2 to display courses:");
            System.out.print("\n enter 3 to search course:");
            System.out.print("\n enter 4 to update course:");
            System.out.print("\n enter 5 to delete a course:");
            List<AnyCourse> courseList;
            ManageCourse manage=new ManageCourse();
            n=menu();
            if(n==1){
            manage.addCourse(manage.courseInput());
            }
            else if(n==2){
                courseList=manage.desrialize();
                DisplayDetail.displayCoursesList(courseList);
            }
            else if(n==3){
                Scanner scanner=new Scanner(System.in);
                courseList=manage.desrialize();
                System.out.print("\n enter course code to search search:");
                String code=scanner.nextLine();
                DisplayDetail.displayCourseByCode(courseList,code);
            }
            else if(n==4){
                courseList=manage.desrialize();
                manage.updateCourse(courseList);
            }
            else if(n==5){
                courseList=manage.desrialize();
                manage.deleteCourse(courseList);
            }
            else if(n==0){break;}
            else{
                System.out.println("Invalid input.");
            }
          }
    }

    public static void studentAndCourseManagement(){
        List<Grading> gradingList;
        int n;
    while(true){
    System.out.print("\n enter 1 assign mark to students:");
    System.out.print("\n enter 2 see student result by id:");
    System.out.print("\n enter 0 to quit!\n");
    n=menu();

    if(n==0){System.out.println("\nbye!");
        break;}
    else if(n==1){
        gradingList=desrialize();
        assignCourse(gradingList);
    }
    else if(n==2){
        gradingList=desrialize();
        Scanner scanner=new Scanner(System.in);
        System.out.print("\n enter student id to see results:");
        String id=scanner.nextLine();
        DisplayDetail.displayGradingList(gradingList,id);

    }
    else{
        System.out.println("invalid input!");
    }
    }

    }
    public static Student studentInput(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("\n enter student Id:");
        String id=scanner.nextLine();
        System.out.print("\n enter student Name:");
        String name=scanner.nextLine();
      System.out.print("\n enter student Gender:");
        String gender=scanner.nextLine();
        return new Student(id,name,gender);
    }
    public static void assignCourse(List<Grading> gradingList){
        System.out.print("\n enter student id to insert mark;");
        Scanner scanner = new Scanner(System.in);
        String idToUpdate = scanner.nextLine();

        boolean studentFound = false;

        for (Grading grading : gradingList) {
            if (grading.getStudent().getStudentId().equals(idToUpdate)) {
                System.out.println("Student found! Enter new information:");

                // Register for new semister
                grading.setSemisterCourses();
                grading.assignCourse();

                // Update course scores
                //updateCourseScores(grading);

                System.out.println("Student information updated successfully!");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + idToUpdate + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(gradingList);
    }
    public static void updateStudent(List<Grading> gradingList) {
        System.out.print("\n enter student id to update information:");
        Scanner scanner = new Scanner(System.in);
        String idToUpdate = scanner.nextLine();

        boolean studentFound = false;

        for (Grading grading : gradingList) {
            if (grading.getStudent().getStudentId().equals(idToUpdate)) {
                System.out.println("Student found! Enter new information:");

                // Update student information
                grading.setStudent(studentInput());

                // Update course scores
                //updateCourseScores(grading);

                System.out.println("Student information updated successfully!");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + idToUpdate + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(gradingList);
    }


    public static void registerStudent(List<Grading> gradingList) {
        System.out.print("\n enter student id Regiser for new semister:");
        Scanner scanner = new Scanner(System.in);
        String idToUpdate = scanner.nextLine();

        boolean studentFound = false;

        for (Grading grading : gradingList) {
            if (grading.getStudent().getStudentId().equals(idToUpdate)) {
                System.out.println("Student found! Enter new information:");

                // Register for new semister
                System.out.print("\n enter student year:");
                int y=scanner.nextInt();
                System.out.print("\n enter student semiser:");
                int s=scanner.nextInt();
                grading.getStudent().setStudentYear(y);
                grading.getStudent().setStudentSemister(s);

                // Update course scores
                //updateCourseScores(grading);

                System.out.println("Student information updated successfully!");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + idToUpdate + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(gradingList);
    }


    public static void deleteStudent(List<Grading> gradingList) {
        System.out.print("\n enter student id to delete:");
        Scanner scanner = new Scanner(System.in);
        String idToDelete = scanner.nextLine();

        boolean studentFound = false;

        for (Grading grading : gradingList) {
            if (grading.getStudent().getStudentId().equals(idToDelete)) {
                gradingList.remove(grading);
                System.out.println("Student with ID " + idToDelete + " deleted successfully!");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + idToDelete + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(gradingList);
    }

    public static void addStudent(Student student){

        List<Grading> gradingList=desrialize();
      
        Grading grading = new Grading(student);
        gradingList.add(grading);
        serializeToFile(gradingList);
    }
   
    private static void serializeToFile(List<Grading> gradingList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(gradingList);
            System.out.println("Grading objects have been serialized to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Grading> desrialize(){
        List<Grading> gradingList=deserializeFromFile();
        if (gradingList == null) {
            gradingList = new ArrayList<>();
        }
        return gradingList;
    }

    private static List<Grading> deserializeFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                return (List<Grading>) obj;
            } else {
                System.out.println("File does not contain a valid List of Grading objects.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // File not found or empty
            // Suppress exception as it's expected when the file is not present initially
        }
        return null;
    }
public static int menu(){
    Scanner scanner=new Scanner(System.in);
    int n;
   System.out.print("\n please enter your choice:");
   n=scanner.nextInt();
   return n;
    
}
  
}

