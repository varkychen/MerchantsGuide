package guide.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import guide.commands.Command;
import guide.strategy.InputStrategy;

public class CalcManager {

    private static CalcManager instance;

    private CalcManager() {}

    public static CalcManager getInstance() {
        if(instance ==null)
            instance = new CalcManager();
        return instance;
    }
    
    protected Map<String, Measure> table = new HashMap<>();

    public Command handle(InputStrategy input) {
        return input.invoke(table);
    }

    public void reset() {
        table.clear();
    }

    public Measure calculateNumber(String[] copyOf) {
        Measure[] measureArray = new Measure[copyOf.length];
        for(int i=0; i< copyOf.length; i++)
            measureArray[i] = table.get(copyOf[i]);
        return calculateNumber(measureArray);
    }

    public Measure calculateNumber(Measure[] number) {
        StringBuffer buffer = new StringBuffer();
        Arrays.stream(number).filter(n -> n.getSymbol() != null).forEach(n -> buffer.append(n.getSymbol()));
        double noOfUnits = calculateNumber(buffer.toString());
        Measure resultMeasure = new Measure(null, null, noOfUnits);
        
        if(number[number.length-1].getSymbol() == null) {
            Measure measure = number[number.length-1];
            noOfUnits *= measure.getValue();
            resultMeasure = new Measure(null, measure.getUnits(), noOfUnits);
        }
        
        return resultMeasure;
    }

    public double calculateNumber(String romanNumber) {
        initialValidation(romanNumber);
        
        double sum = 0;
        double previousDigit = 0;
        StringBuffer buf2 = new StringBuffer();
        boolean doSubtract = false;
        for(int i=0; i <romanNumber.length(); i++) {
            double digit = getDigit(romanNumber.charAt(i));

            if(i>0) buf2.append(romanNumber.charAt(i-1));
            if(buf2.length() > 2) buf2.deleteCharAt(0);
            String pre2 = buf2.toString();
            
            if(pre2.length() == 2 && doSubtract && digit >= getDigit(pre2.charAt(0)))
                throw new IllegalArgumentException("Invalid sequence of digits");
            if(previousDigit <= digit) {
                if(previousDigit == 5 || previousDigit == 50 || previousDigit == 500)
                    throw new IllegalArgumentException("Cannot subtract if previous digit is V, L or D");
                if(buf2.length() == 2 && (pre2.equals("II") || pre2.equals("XX") || pre2.equals("CC")))
                    throw new IllegalArgumentException("Subtract previous digit only if I, X or C was repeated once");
            }
            
            double intermediateSum = 0;
            if(previousDigit < digit) {
                doSubtract = true;
                intermediateSum = digit - previousDigit - (sum == 0 ? 0 : previousDigit);
            } else {
                doSubtract = false;
                intermediateSum = digit;
            }
            sum += intermediateSum;
            previousDigit = digit;
        }
        return sum;
    }

    private void initialValidation(String romanNumber) {
        Pattern p = Pattern.compile("IIII|XXXX|CCCC|MMMM|VV|LL|DD");
        if(p.matcher(romanNumber).find())
            throw new IllegalArgumentException("Roman numbers cannot have more than 4 repeated characters");
    }

    private double getDigit(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException("Roman Number can only be one of [IVXLCDM]");
        }
    }
}
