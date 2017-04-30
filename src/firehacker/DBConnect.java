package firehacker;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBConnect {
    
    public static void main(String[] args){
        
        try {
            
        String host = "jdbc:derby://localhost:1527/FireHackerDB";
        String uName = "LukeRobbins2112";
        String uPass = "Tootsie1889";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement();
        String SQL = "SELECT * FROM QuizQuestions";
        ResultSet rs = stmt.executeQuery(SQL);
        
        while(rs.next()){
            int questionID = rs.getInt("QuestionID");
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            System.out.println(questionID + ". " + questionHeader);
            System.out.println(optionA);
            System.out.println(optionB);
            System.out.println(optionC);
            System.out.println(optionD);
            System.out.println("Hint: " + hint);
            System.out.println("\n\n");
        }
        
        }
        
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
        
        
        
        
    }
    
}
