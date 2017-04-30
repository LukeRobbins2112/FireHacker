package firehacker;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Concepts demonstrated:
 * Variables
 * Conditionals (6)
 * Iteration (1)
 * File I/O
 * User-defined methods that pass arguments
 * User-defined methods that return a value
 * Storing application's data in file (and database)
 * Allow user to specify file written to
 * Allow user to write to existing file
 * Using ArrayList(1)
 * this reference variable
 * String methods (5)
 * Wrapper classes (use Integer several times)
 * Aggregation (using GradeBook and StudyGuideBuilder classes)
 * 
 * @author LukeRobbins2112
 * 
 */

public class FireHackerWindow extends javax.swing.JFrame {
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    boolean addToGuide;
    String guideAddition;
    int numAnswered;
    int numRight;
    private GradeBook book;
    
    StudyGuideBuilder builder;
    //File file;
    //FileWriter fw;

    public FireHackerWindow() throws IOException{
        initComponents();
        DoConnect();
        this.addToGuide = false;
        this.guideAddition = "";
        this.numAnswered = 0;
        this.numRight = 0;
        this.book = new GradeBook();
    }
    
    public void createBuilder() throws IOException{
        String guideName = JOptionPane.showInputDialog(this, "Please enter the name of the file you wish to write to "
                + "for your study guide: ");
        //this.file = new File(guideName);
        //this.fw = new FileWriter(guideName);
        this.builder = new StudyGuideBuilder(guideName);
    }
    
    
    public void DoConnect() throws IOException{
        
         try {
            //CONNECT TO THE DATABASE
        String host = "jdbc:derby://localhost:1527/FireHackerDB";
        String uName = "LukeRobbins2112";
        String uPass = "Tootsie1889";
        
        //EXECUTE SQL AND LOAD RECORDS INTO RECORD SET
        con = DriverManager.getConnection(host, uName, uPass);
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM QuizQuestions";
        rs = stmt.executeQuery(SQL);
        
        //MOVE CURSOR TO FIRST POSITION AND GET DATA
            rs.next();
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY FIRST RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
        
            
        }
        
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        QuestionNo = new javax.swing.JTextField();
        QuestionHeader = new javax.swing.JTextField();
        ChoiceA = new javax.swing.JTextField();
        ChoiceB = new javax.swing.JTextField();
        ChoiceC = new javax.swing.JTextField();
        ChoiceD = new javax.swing.JTextField();
        QuestionLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        newAnswerLetter = new javax.swing.JTextField();
        newAnswerLetterLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnUpdateQuestion = new javax.swing.JButton();
        btnDeleteQuestion = new javax.swing.JButton();
        btnNewQuestion = new javax.swing.JButton();
        btnSaveNewQuestion = new javax.swing.JButton();
        btnCancelNewQuestion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        yourAnswerLabel = new javax.swing.JLabel();
        userAnswerLetter = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        hint = new javax.swing.JTextField();
        hintButton = new javax.swing.JButton();
        retakeQuiz = new javax.swing.JButton();
        showPerformance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QuestionHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionHeaderActionPerformed(evt);
            }
        });

        QuestionLabel.setText("Question:");

        btnFirst.setText("First");
        btnFirst.setEnabled(false);
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.setEnabled(false);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.setEnabled(false);
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        newAnswerLetter.setEnabled(false);

        newAnswerLetterLabel.setText("New Answer Letter:");
        newAnswerLetterLabel.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addGap(127, 127, 127)
                .addComponent(btnLast))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newAnswerLetterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newAnswerLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newAnswerLetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newAnswerLetterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(39, 39, 39))
        );

        btnUpdateQuestion.setText("Update Question");
        btnUpdateQuestion.setEnabled(false);
        btnUpdateQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQuestionActionPerformed(evt);
            }
        });

        btnDeleteQuestion.setText("Delete Question");
        btnDeleteQuestion.setEnabled(false);
        btnDeleteQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteQuestionActionPerformed(evt);
            }
        });

        btnNewQuestion.setText("New Question");
        btnNewQuestion.setEnabled(false);
        btnNewQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewQuestionActionPerformed(evt);
            }
        });

        btnSaveNewQuestion.setText("Save New Question");
        btnSaveNewQuestion.setEnabled(false);
        btnSaveNewQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewQuestionActionPerformed(evt);
            }
        });

        btnCancelNewQuestion.setText("Cancel New Question");
        btnCancelNewQuestion.setEnabled(false);
        btnCancelNewQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelNewQuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateQuestion)
                .addGap(33, 33, 33)
                .addComponent(btnDeleteQuestion)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnSaveNewQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnNewQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnCancelNewQuestion)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewQuestion)
                    .addComponent(btnSaveNewQuestion)
                    .addComponent(btnCancelNewQuestion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateQuestion)
                    .addComponent(btnDeleteQuestion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAnswerLabel.setText("Your Answer:");

        userAnswerLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAnswerLetterActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(yourAnswerLabel)
                .addGap(18, 18, 18)
                .addComponent(userAnswerLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yourAnswerLabel)
                    .addComponent(userAnswerLetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addGap(14, 14, 14))
        );

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        endButton.setText("END");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        hintButton.setText("Hint");
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });

        retakeQuiz.setText("Retake Quiz");
        retakeQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retakeQuizActionPerformed(evt);
            }
        });

        showPerformance.setText("Show Performance");
        showPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPerformanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(startButton)
                .addGap(144, 144, 144)
                .addComponent(retakeQuiz)
                .addGap(26, 26, 26)
                .addComponent(showPerformance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuestionNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(hintButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hint))
                        .addComponent(ChoiceD, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                        .addComponent(ChoiceC)
                        .addComponent(ChoiceA)
                        .addComponent(QuestionHeader)
                        .addComponent(ChoiceB)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(QuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuestionNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(ChoiceA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChoiceB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChoiceD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChoiceC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hintButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(endButton)
                    .addComponent(retakeQuiz)
                    .addComponent(showPerformance)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void QuestionHeaderActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            if (rs.next()){
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY NEXT RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            this.hint.setText("");
            this.userAnswerLetter.setText("");
            }
            
            else{
                rs.previous();
                JOptionPane.showMessageDialog(FireHackerWindow.this, "End of file");
            }
        }
        catch(SQLException err) {
            JOptionPane.showMessageDialog(FireHackerWindow.this, err.getMessage());
        }
    }                                       

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            if (rs.previous()){
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY NEXT RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            this.hint.setText("");
            this.userAnswerLetter.setText("");
            }
            
            else{
                rs.next();
                JOptionPane.showMessageDialog(FireHackerWindow.this, "Beginning of file");
            }
        }
        catch(SQLException err) {
            JOptionPane.showMessageDialog(FireHackerWindow.this, err.getMessage());
        }
    }                                           

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            rs.first();
            
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY NEXT RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            this.hint.setText("");
            this.userAnswerLetter.setText("");
        }
        catch(SQLException err) {
            JOptionPane.showMessageDialog(FireHackerWindow.this, err.getMessage());
        }
    }                                        

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            rs.last();
            
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY NEXT RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            this.hint.setText("");
            this.userAnswerLetter.setText("");
        }
        catch(SQLException err) {
            JOptionPane.showMessageDialog(FireHackerWindow.this, err.getMessage());
        }
    }                                       

    private void btnUpdateQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String qHeader = this.QuestionHeader.getText();
        String aChoice = this.ChoiceA.getText();
        String bChoice = this.ChoiceB.getText();
        String cChoice = this.ChoiceC.getText();
        String dChoice = this.ChoiceD.getText();
        String qNumber = this.QuestionNo.getText();
        
        int intQNumber = Integer.parseInt(qNumber);
        
        try{
            this.rs.updateInt("QuestionID", intQNumber);
            this.rs.updateString("QuestionHeader", qHeader);
            this.rs.updateString("OptionA", aChoice);
            this.rs.updateString("OptionB", bChoice);
            this.rs.updateString("OptionC", cChoice);
            this.rs.updateString("OptionD", dChoice);
            this.rs.updateRow();
            JOptionPane.showMessageDialog(this, "Updated");
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
        
    }                                                 

    private void btnNewQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        try{
        curRow = this.rs.getRow();
        
        this.QuestionHeader.setText("");
        this.QuestionNo.setText("");
        this.ChoiceA.setText("");
        this.ChoiceB.setText("");
        this.ChoiceC.setText("");
        this.ChoiceD.setText("");
        
        
        btnFirst.setEnabled( false );
        btnPrevious.setEnabled( false ) ;
        btnNext.setEnabled( false );
        btnLast.setEnabled( false );
        btnUpdateQuestion.setEnabled( false );
        btnDeleteQuestion.setEnabled( false );
        btnNewQuestion.setEnabled( false );

        btnSaveNewQuestion.setEnabled( true );
        btnCancelNewQuestion.setEnabled( true );
        newAnswerLetter.setEnabled(true);
        newAnswerLetterLabel.setEnabled(true);
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }                                              

    private void btnCancelNewQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
       
        try{
        this.rs.absolute(curRow);
        
        this.QuestionHeader.setText(this.rs.getString("QuestionHeader"));
        this.QuestionNo.setText(this.rs.getString("QuestionID"));
        this.ChoiceA.setText(this.rs.getString("OptionA"));
        this.ChoiceB.setText(this.rs.getString("OptionB"));
        this.ChoiceC.setText(this.rs.getString("OptionC"));
        this.ChoiceD.setText(this.rs.getString("OptionD"));
        
        btnFirst.setEnabled( true );
        btnPrevious.setEnabled( true ) ;
        btnNext.setEnabled( true );
        btnLast.setEnabled( true );
        btnUpdateQuestion.setEnabled( true );
        btnDeleteQuestion.setEnabled( true );
        btnNewQuestion.setEnabled( true );

        btnSaveNewQuestion.setEnabled( false );
        btnCancelNewQuestion.setEnabled( false );
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }                                                    

    private void btnSaveNewQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        String quesHeader = this.QuestionHeader.getText();
        String answerA = this.ChoiceA.getText();
        String answerB = this.ChoiceB.getText();
        String answerC = this.ChoiceC.getText();
        String answerD = this.ChoiceD.getText();
        String ansLetter = this.newAnswerLetter.getText();
        String quesID = this.QuestionNo.getText();
        int intQuesID = Integer.parseInt(quesID);
        
        try{
            this.rs.moveToInsertRow();
            
            this.rs.updateInt("QuestionID", intQuesID);
            this.rs.updateString("QuestionHeader", quesHeader);
            this.rs.updateString("OptionA", answerA);
            this.rs.updateString("OptionB", answerB);
            this.rs.updateString("OptionC", answerC);
            this.rs.updateString("OptionD", answerD);
            this.rs.updateString("AnswerLetter", ansLetter);
            
            this.rs.insertRow();
            this.stmt.close();
            this.rs.close();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM QuizQuestions";
            rs = stmt.executeQuery(SQL);
        
            //MOVE CURSOR TO NEXT POSITION AND GET DATA
            rs.next();
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY FIRST RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true) ;
            btnNext.setEnabled(true);
            btnLast.setEnabled( true );
            btnUpdateQuestion.setEnabled( true );
            btnDeleteQuestion.setEnabled( true );
            btnNewQuestion.setEnabled( true );

            btnSaveNewQuestion.setEnabled( false );
            btnCancelNewQuestion.setEnabled( false );
            
            JOptionPane.showMessageDialog(this, "New question saved");
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        
    }                                                  

    private void btnDeleteQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try{
            
            this.rs.deleteRow();
            this.stmt.close();
            this.rs.close();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM QuizQuestions";
            rs = stmt.executeQuery(SQL);
        
            //MOVE CURSOR TO NEXT POSITION AND GET DATA
            rs.next();
            int questionID = rs.getInt("QuestionID");
            String ID_column = Integer.toString(questionID);
            String questionHeader = rs.getString("QuestionHeader");
            String optionA = rs.getString("OptionA");
            String optionB = rs.getString("OptionB");
            String optionC = rs.getString("OptionC");
            String optionD = rs.getString("OptionD");
            String answerLetter = rs.getString("AnswerLetter");
            String hint = rs.getString("Hint");
            
            //DISPLAY FIRST RECORD IN THE TEXT FIELDS
            this.QuestionNo.setText(ID_column);
            this.QuestionHeader.setText(questionHeader);
            this.ChoiceA.setText(optionA);
            this.ChoiceB.setText(optionB);
            this.ChoiceC.setText(optionC);
            this.ChoiceD.setText(optionD);
            
            JOptionPane.showMessageDialog(this, "Question deleted");
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }                                                 

    private void userAnswerLetterActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    public String answerToString() throws SQLException{
        return ("Question: " + this.rs.getString("QuestionHeader") + "\n" + this.rs.getString("OptionA") 
                + "\n" + this.rs.getString("OptionB") + "\n" + this.rs.getString("OptionC") + "\n" 
                + this.rs.getString("OptionD") + "\n" + "Hint: " + 
                this.rs.getString("Hint")+ "\n" + "Answer: " + this.rs.getString("AnswerLetter") + "\n\n");
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             

        try{
            this.numAnswered++;
            String correctAnswerLetter = rs.getString("AnswerLetter");
            String userAnswer = this.userAnswerLetter.getText();
            
            if (correctAnswerLetter.equalsIgnoreCase(userAnswer)){
                JOptionPane.showMessageDialog(this, "Correct!");
                this.numRight++;
                this.btnNextActionPerformed(evt);
            }
            else if (this.addToGuide){
                String addToGuide = JOptionPane.showInputDialog(this, "Incorrect. Would you like to add this question "
                        + "to your study guide? Enter 'Yes' to do so.");
                if (addToGuide.equalsIgnoreCase("Yes")){
                    this.guideAddition += answerToString();
                }
            }
            else{
                
                JOptionPane.showMessageDialog(this, "Incorrect. ");
            }
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        
    }                                            

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        try{
            
        String writeToGuide = JOptionPane.showInputDialog(this, "Would you like to write to study guide? Enter "
                + "'Yes' to do so.");
        if (writeToGuide.equalsIgnoreCase("Yes")){
            this.addToGuide = true;
            createBuilder();
        }
        
        
        btnFirst.setEnabled( true );
        btnPrevious.setEnabled( true ) ;
        btnNext.setEnabled( true );
        btnLast.setEnabled( true );
        btnUpdateQuestion.setEnabled( true );
        btnDeleteQuestion.setEnabled( true );
        btnNewQuestion.setEnabled( true );
        submitButton.setEnabled(true);
        startButton.setEnabled(false);


        }
        catch (IOException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        
    }                                           

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (this.addToGuide){
            this.builder.addToGuide(this.guideAddition);
        }
        
        this.dispose();
        System.exit(0);
        
    }                                         

    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        try{
            String hintText = this.rs.getString("Hint");
            this.hint.setText(hintText);
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        
    }                                          

    public void saveGrade(){
        double grade = 0.0;
        String saveGrade = JOptionPane.showInputDialog(this, "Would you like to save your grade for this quiz? "
                + "Enter 'Yes' to do so.");
        if (saveGrade.equalsIgnoreCase("Yes")){
            grade = (this.numRight / this.numAnswered) * 100;
            this.book.addGradeToBook(grade);
        }
        JOptionPane.showMessageDialog(this, this.book.getGrades());
    }
    
    private void retakeQuizActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //JOptionPane.showMessageDialog(this, this.book.getGrades());
        saveGrade();
        this.btnFirstActionPerformed(evt);
        this.numAnswered = 0;
        this.numRight = 0;
    }                                          

    private void showPerformanceActionPerformed(java.awt.event.ActionEvent evt) {                                                
        JOptionPane.showMessageDialog(this, "Quiz average: " + this.book.gradeAverage());
        JOptionPane.showMessageDialog(this, "Quiz letter grade: " + this.book.getLetterGrade(this.book.gradeAverage()));
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FireHackerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FireHackerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FireHackerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FireHackerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                new FireHackerWindow().setVisible(true);
                }
                catch (IOException i){
                    i.getMessage();
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField ChoiceA;
    private javax.swing.JTextField ChoiceB;
    private javax.swing.JTextField ChoiceC;
    private javax.swing.JTextField ChoiceD;
    private javax.swing.JTextField QuestionHeader;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JTextField QuestionNo;
    private javax.swing.JButton btnCancelNewQuestion;
    private javax.swing.JButton btnDeleteQuestion;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewQuestion;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveNewQuestion;
    private javax.swing.JButton btnUpdateQuestion;
    private javax.swing.JButton endButton;
    private javax.swing.JTextField hint;
    private javax.swing.JButton hintButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField newAnswerLetter;
    private javax.swing.JLabel newAnswerLetterLabel;
    private javax.swing.JButton retakeQuiz;
    private javax.swing.JButton showPerformance;
    private javax.swing.JButton startButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField userAnswerLetter;
    private javax.swing.JLabel yourAnswerLabel;
    // End of variables declaration                   
}
