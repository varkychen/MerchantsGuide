package guide.strategy;

import java.util.Arrays;
import java.util.Map;

import guide.commands.NoOpCommand;
import guide.core.CalcManager;
import guide.core.Measure;

public class CompoundFactStrategy implements InputStrategy {
    
    private String input;

    public CompoundFactStrategy(String input) {
        this.input = input;
    }

    @Override
    public NoOpCommand invoke(Map<String, Measure> dictionary) {
        String[] tokens = input.split("is");
        String[] prefix = tokens[0].trim().split(" ");
        Measure result = CalcManager.getInstance().calculateNumber(Arrays.copyOf(prefix, prefix.length -1));
        double quantity = result.getValue();
        
        String[] suffix = tokens[1].trim().split(" ");
        String units = suffix[1].trim();
        double value = Double.parseDouble(suffix[0].trim());
        
        dictionary.put(prefix[prefix.length-1], new Measure(null, units, value/quantity));
        return new NoOpCommand();
    }
}
