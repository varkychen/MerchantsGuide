package guide.core;

public class Measure {
    private final String symbol;
    private final String units;
    private final double value;
    
    public Measure(String symbol, String units, double value) {
        this.symbol = symbol;
        this.units = units;
        this.value = value;
    }
    
    public String getUnits() {
        return units;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public double getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        result = prime * result + ((units == null) ? 0 : units.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object o) {
        if(o != null && o instanceof Measure) {
            Measure measure = (Measure)o;
            boolean equals = (measure.getValue() == value);
            boolean areUnitsSame = (measure.getUnits() == null && units == null);
            areUnitsSame = areUnitsSame || measure.getUnits().equals(units);
            equals = equals && areUnitsSame;
            return equals;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Measure [symbol=" + symbol + ", units=" + units + ", value=" + value + "]";
    }
}
