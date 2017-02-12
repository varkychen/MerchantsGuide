package guide.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guide.strategy.CompoundFactStrategy;
import guide.strategy.FactStrategy;

public class CompoundFactStrategyTest {

    private CalcManager instance;

    @Before
    public void setUp() throws Exception {
        instance = CalcManager.getInstance();
        instance.reset();
        instance.handle(new FactStrategy("abcd is I"));
        instance.handle(new FactStrategy("bcde is V"));
        instance.handle(new FactStrategy("cdef is X"));
    }

    @Test
    public void testCompoundFactStrategyForOneUnit() {
        CompoundFactStrategy strategy = new CompoundFactStrategy("abcd Apple is 5 Fruits");
        strategy.invoke(instance.table);
        Assert.assertEquals(4, instance.table.size());
        Assert.assertTrue(instance.table.containsKey("Apple"));
        
        Measure measure = instance.table.get("Apple");
        Assert.assertNull(measure.getSymbol());
        Assert.assertEquals("Fruits", measure.getUnits());
        Assert.assertEquals(5.0d, measure.getValue(), 0d);
    }

    @Test
    public void testCompoundFactStrategyForSimpleCalculation() {
        CompoundFactStrategy strategy = new CompoundFactStrategy("bcde Tomato is 5 Vegetables");
        strategy.invoke(instance.table);
        Assert.assertEquals(4, instance.table.size());
        Assert.assertTrue(instance.table.containsKey("Tomato"));
        
        Measure measure = instance.table.get("Tomato");
        Assert.assertNull(measure.getSymbol());
        Assert.assertEquals("Vegetables", measure.getUnits());
        Assert.assertEquals(1.0d, measure.getValue(), 0d);
    }
    
    @Test
    public void testCompoundFactStrategyForComplexCalculation() {
        CompoundFactStrategy strategy = new CompoundFactStrategy("cdef bcde Wine is 225 Beverage");
        strategy.invoke(instance.table);
        Assert.assertEquals(4, instance.table.size());
        Assert.assertTrue(instance.table.containsKey("Wine"));
        
        Measure measure = instance.table.get("Wine");
        Assert.assertNull(measure.getSymbol());
        Assert.assertEquals("Beverage", measure.getUnits());
        Assert.assertEquals(15d, measure.getValue(), 0d);
    }
}
