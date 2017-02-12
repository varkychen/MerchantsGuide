package guide.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guide.strategy.FactStrategy;

public class CalcManagerTest {

    private CalcManager instance;

    @Before
    public void setUp() {
        instance = CalcManager.getInstance();
        instance.handle(new FactStrategy("abcd is I"));
    }
    
    @Test
    public void testCalculateOneDigit() {
        Measure result = instance.calculateNumber(new String[] {"abcd"});
        Assert.assertEquals(1.0d, result.getValue(), 0d);
    }
    
    @Test
    public void testCalculate_I_1() {
        Measure[] number = new Measure[] {new Measure("I", null, 1d)};
        Measure result = instance.calculateNumber(number);
        Assert.assertEquals(1.0d, result.getValue(), 0d);
    }

    @Test
    public void testCalculate_II_2() {
        double value = instance.calculateNumber("II");
        Assert.assertEquals(2.0d, value, 0d);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCalculate_IIII_Exception() {
        instance.calculateNumber("IIII");
    }

    @Test
    public void testCalculate_V_5() {
        Measure result = instance.calculateNumber(new Measure[] {new Measure("V", null, 5d)});
        Assert.assertEquals(5.0d, result.getValue(), 0d);
    }
}
