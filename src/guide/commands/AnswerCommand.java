package guide.commands;

import guide.core.Measure;

public class AnswerCommand implements Command {

    private String question;
    private Measure answer;
    
    public AnswerCommand(String question, Measure answer) {
        this.question = question;
        this.answer = answer;
    }
    
    @Override
    public void execute() {
        System.out.printf("%s is %01.0f %ss%n", question, answer.getValue(), answer.getUnits());
    }

    public Measure getAnswer() {
        return this.answer;
    }
}
