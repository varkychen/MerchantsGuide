package guide.strategy;

import java.util.HashMap;
import java.util.Map;

import guide.commands.NoOpCommand;
import guide.core.Measure;

public class FactStrategy implements InputStrategy {

    private static final Map<String, Double> symbolValueMap = new HashMap<>();
    
    static {
        symbolValueMap.put("I", 1.0d);
        symbolValueMap.put("V", 5.0d);
        symbolValueMap.put("X", 10.0d);
        symbolValueMap.put("L", 50.0d);
        symbolValueMap.put("C", 100.0d);
        symbolValueMap.put("D", 500.0d);
        symbolValueMap.put("M", 1000.0d);
    }
    private final String numeral;
    private final Measure measure;
    
    public FactStrategy(String input) {
        String[] elements = input.split("is");
        this.numeral = elements[0].trim();
        String symbol = elements[1].trim();
        Double value = symbolValueMap.get(symbol);
        this.measure = new Measure(symbol, null, value);
    }
    
    public String getSymbol() {
        return numeral;
    }
    
    public Measure getMeasure() {
        return measure;
    }

    @Override
    public NoOpCommand invoke(Map<String, Measure> dictionary) {
        dictionary.put(numeral, measure);
        return new NoOpCommand();
    }
}
