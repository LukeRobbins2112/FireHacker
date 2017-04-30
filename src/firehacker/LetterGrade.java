package firehacker;

/**
 * Concepts demonstrated:
 * Enums
 * Getter method
 * User defined method
 * 
 * @author LukeRobbins2112
 */



public enum LetterGrade {
    
    A("A"), B("B"), C("C"), D("D"), F("F"), UNGRADED("UNGRADED");
    
    private String answerLetter;
    
    private LetterGrade(String answerLetter){
        this.answerLetter = answerLetter;
    }
    
    public String getAnswerLetter(){
        return answerLetter;
    }




}
