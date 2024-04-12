package secondyear;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageCourse {
    private static final String FILE_PATH = "course_data.ser";
    public static AnyCourse courseInput(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("\n enter course code:");
        String code=scanner.nextLine();
        System.out.print("\n enter course Name:");
        String name=scanner.nextLine();
        System.out.print("\n enter course year:");
        int year=scanner.nextInt();
        System.out.print("\n enter course semister:");
        int semister=scanner.nextInt();
        System.out.print("\n enter course credit hour:");
        int creditHour=scanner.nextInt();
        return new AnyCourse(code,name,year,semister,creditHour);
    }

   public static void addCourse(AnyCourse course){

        List<AnyCourse> courseList=desrialize();
        //Grading grading= addStudent(studentInput());
        courseList.add(course);
        serializeToFile(courseList);
    }


    public static void updateCourse(List<AnyCourse> courseList) {
        System.out.print("\n enter course code to update information:");
        Scanner scanner = new Scanner(System.in);
        String idToUpdate = scanner.nextLine();

        boolean courseFound = false;

        for (AnyCourse course: courseList) {
            if (course.getCourseCode().equals(idToUpdate)) {
                System.out.println("course found! Enter new information:");

               System.out.print("\n enter course code to update:");
               String code=scanner.nextLine();
               System.out.print("\n enter course name to update:");
               String name=scanner.nextLine();
               System.out.print("\n enter course year to update:");
              // scanner.nextLine();
               int year=scanner.nextInt();
               System.out.print("\n enter course semister to update:");
               int semister=scanner.nextInt();
               System.out.print("\n enter course credit hour to update:");
               int credit=scanner.nextInt();
               course.setCourseCode(code);
               course.setCourseName(name);
               course.setYear(year);
               course.setSemister(semister);
               course.setCreditHour(credit);

                // Update course scores
                //updateCourseScores(grading);

                System.out.println("Course information updated successfully!");
                courseFound = true;
                break;
            }
        }

        if (!courseFound) {
            System.out.println("Student with ID " + idToUpdate + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(courseList);
    }

    

    public static List<AnyCourse> desrialize(){
        List<AnyCourse> courseList=deserializeFromFile();
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        return courseList;
    }

    public static List<AnyCourse> deserializeFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                return (List<AnyCourse>) obj;
            } else {
                System.out.println("File does not contain a valid List of Grading objects.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // File not found or empty
            // Suppress exception as it's expected when the file is not present initially
        }
        return null;
    }

    public static void serializeToFile(List<AnyCourse> courseList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(courseList);
            System.out.println("Grading objects have been serialized to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void deleteCourse(List<AnyCourse> courseList) {
        System.out.print("\n enter course code to delete:");
        Scanner scanner = new Scanner(System.in);
        String idToDelete = scanner.nextLine();

        boolean courseFound = false;

        for (AnyCourse course: courseList) {
            if (course.getCourseCode().equals(idToDelete)) {
                courseList.remove(course);
                System.out.println("Course with course code " + idToDelete + " deleted successfully!");
                courseFound = true;
                break;
            }
        }

        if (!courseFound) {
            System.out.println("Course with course code " + idToDelete + " not found!");
        }

        // Save the updated list to the file
        serializeToFile(courseList);
    }

   
}
