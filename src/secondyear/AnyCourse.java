package secondyear;

import java.util.Arrays;

public class AnyCourse extends Course{
    private int year;
    private int semister;
    private int creditHour;
    public AnyCourse(String courseCode, String courseName,int year,int semister,int creditHour){
        super(courseCode, courseName);
        if(year>0){this.year=year;}
        if(semister==1||semister==2){
            this.semister=semister;
        }
        if(creditHour>0){this.creditHour=creditHour;}
    }
      @Override
     public double getPoints(){
        try{
     String[] grades={"A+","A","A-","B+","B","B-","C+","C","C-","D","F"};
     double[] points={4,4,3.75,3.5,3,2.75,2.5,2,1.75,1.5,1,0};
     int index= Arrays.asList(grades).indexOf(getGrade());
     if(index>-1){
     return points[index]*creditHour;
     }
     return 0;
        }
        catch(Error error){
            return 0;
        }
     }

     

     public void setSemister(int semister){if(semister==1||semister==2){
        this.semister=semister;
     }
    }
    public void setYear(int year){
        if(year>0){
            this.year=year;
        }
    }
    public void setCreditHour(int creditHour){
        if(creditHour>0){
            this.creditHour=creditHour;
        }
    }

    public int getSemister(){return semister;}
    public int getyear(){return year;}
    public int getCreditHour(){return creditHour;}
}
