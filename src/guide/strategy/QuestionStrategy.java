package guide.strategy;

import java.util.Map;

import guide.commands.AnswerCommand;
import guide.core.CalcManager;
import guide.core.Measure;

public class QuestionStrategy implements InputStrategy {

    private String input;

    public QuestionStrategy(String input) {
        this.input = input;
    }
    
    @Override
    public AnswerCommand invoke(Map<String, Measure> dictionary) {
        //abcd abcd is 
        String[] items = input.split("is");
        String question = items[1].split("\\?")[0].trim();
        String[] parts = question.split(" ");
        Measure answer = CalcManager.getInstance().calculateNumber(parts);
        return new AnswerCommand(question, answer);
    }
}
