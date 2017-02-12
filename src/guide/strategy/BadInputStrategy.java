package guide.strategy;

import java.util.Map;

import guide.commands.NoIdeaCommand;
import guide.core.Measure;

public class BadInputStrategy implements InputStrategy {

    @Override
    public NoIdeaCommand invoke(Map<String, Measure> dictionary) {
        return new NoIdeaCommand();
    }
}
