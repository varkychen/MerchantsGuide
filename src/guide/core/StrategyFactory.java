package guide.core;

import java.util.regex.Pattern;

import guide.strategy.BadInputStrategy;
import guide.strategy.CompoundFactStrategy;
import guide.strategy.FactStrategy;
import guide.strategy.InputStrategy;
import guide.strategy.QuestionStrategy;

public class StrategyFactory {

    public static InputStrategy determineStrategy(String input) {
        Pattern factPattern = Pattern.compile("[a-zA-Z]* is [IVXLCDM]");
        Pattern compoundFactPattern = Pattern.compile("[a-zA-Z ]* is [0-9]* [a-zA-Z]*");
        Pattern questionPattern = Pattern.compile("how m.* is .* ?");
        
        if(factPattern.matcher(input).matches()) {
            return new FactStrategy(input);
        } else if(compoundFactPattern.matcher(input).matches()) {
            return new CompoundFactStrategy(input);
        } else if(questionPattern.matcher(input).matches()) {
            return new QuestionStrategy(input);
        }
        return new BadInputStrategy();
    }

}
