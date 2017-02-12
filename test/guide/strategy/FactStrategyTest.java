package guide.strategy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guide.core.Measure;

public class FactStrategyTest {

    private Map<String, Measure> cache;
    
    @Before
    public void setUp() throws Exception {
        cache = new HashMap<>();
    }

    @Test
    public void testFactStrategy() {
        FactStrategy factStrategy = new FactStrategy("abcd is I");
        factStrategy.invoke(cache);
        Assert.assertEquals(1, cache.size());
        Assert.assertTrue(cache.containsKey("abcd"));
        
        Measure measure = cache.get("abcd");
        Assert.assertEquals("I", measure.getSymbol());
        Assert.assertEquals(1.0, measure.getValue(), 0d);
        Assert.assertNull(measure.getUnits());
    }
}
