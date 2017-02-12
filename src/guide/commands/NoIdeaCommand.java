package guide.commands;

public class NoIdeaCommand implements Command {

    @Override
    public void execute() {
        System.out.println("I have not idea what you are talking about");
    }
}
