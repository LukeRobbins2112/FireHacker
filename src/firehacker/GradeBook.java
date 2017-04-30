package firehacker;




import java.util.*;


public class GradeBook {
    
    private LetterGrade lg;
    private double grade;
    private ArrayList<Double> allGrades;
    
    public GradeBook(){
        this.lg = LetterGrade.UNGRADED;
        this.grade = 0.0;
        this.allGrades = new ArrayList<Double>();
    }
    
    public void setLetterGrade(LetterGrade l){
        this.lg = l;
    }
    
    public LetterGrade getLetterGrade(double d){
        
        if (d >=0 && d < 60){
            this.lg = LetterGrade.F;
        }
        else if (d < 70){
            this.lg = LetterGrade.D;
        }
        else if (d < 80){
            this.lg = LetterGrade.C;
        }
        else if (d < 90){
            this.lg = LetterGrade.B;
        }
        else if (d <= 100){
            this.lg = LetterGrade.A;
        }
        else{
            this.lg = LetterGrade.UNGRADED;
        }
        
        return this.lg;
    }
    
    public String getStringLetterGrade(){
        return this.lg.toString();
    }
    
    public void setGrade(double d){
        this.grade = d;
    }
    
    public double getGrade(){
        return this.grade;
    }
    
    public void addGradeToBook(double gr){
        this.allGrades.add(gr);
    }
    
    public String getGrades(){
        String gradeString = "Your grades for this quiz: ";
        
        for (double d : this.allGrades){
            gradeString += (d + " ");
        }
        
        return gradeString;
    }
    
    public ArrayList<Double> allGrades(){
        return this.allGrades;
    }
    
    public double gradeAverage(){
        double avg = 0;
        
        for (double d : this.allGrades){
            avg += d;
        }
        
        if (this.allGrades.size() > 0){
            return avg/this.allGrades.size();
        }
        return 0;
    }
    
}
