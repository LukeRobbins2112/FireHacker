package firehacker;




import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Concepts demonstrated:
 * Iterations (2)
 * 
 * @author LukeRobbins2112
 */

public class StudyGuideBuilder {
    
    private Scanner reader;
    private File file;
    private FileWriter fw;
    private PrintWriter pw;
    
    public StudyGuideBuilder(String fileName) throws IOException{
        this.file = new File(fileName);
        //checkFile();
        this.reader = new Scanner(this.file);
        this.fw = new FileWriter(fileName, true);
        this.pw = new PrintWriter(this.fw);
    }
    
    public void addToGuide(String addition){
        //while (reader.hasNextLine()) {
            //final String lineFromFile = reader.nextLine();
            //if(lineFromFile.contains(addition)){ 
                //JOptionPane.showMessageDialog(null, "This is already in the guide.");
              //  break;
            //}
            //else{
                this.pw.println(addition);
                this.pw.close();
            //}
        }
    
    public void checkFile() throws IOException{
        while (!this.file.exists()){
            String newFileName = JOptionPane.showInputDialog(null, "That file does not exist. Please enter a proper filename, or continue"
                    + " without saving your results.");
            this.file = new File(newFileName);
            this.fw = new FileWriter(newFileName, true);
            this.pw = new PrintWriter(this.fw);
        }
    }
    
    //}
    
    //Use quiz questions, user input, and answer correctness to identify and format Strings,
    //which are then added to the text StudyGuide file
    
}
