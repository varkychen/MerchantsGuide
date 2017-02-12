package guide.strategy;

import java.util.Map;

import guide.commands.Command;
import guide.core.Measure;

public interface InputStrategy {
    public Command invoke(Map<String, Measure> dictionary);
}
