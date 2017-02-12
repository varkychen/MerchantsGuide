package guide.core;

import org.junit.Assert;
import org.junit.Test;

import guide.strategy.BadInputStrategy;
import guide.strategy.CompoundFactStrategy;
import guide.strategy.FactStrategy;
import guide.strategy.QuestionStrategy;

public class StrategyFactoryTest {

    @Test
    public void testData() {
        FactStrategy fact = (FactStrategy)StrategyFactory.determineStrategy("abcd is I");
        Assert.assertEquals("abcd", fact.getSymbol());
    }
    
    @Test
    public void testInvalidData() {
        BadInputStrategy input = (BadInputStrategy)StrategyFactory.determineStrategy("abcd is G");
        Assert.assertNotNull(input);
    }

    @Test
    public void testCompoundData() {
        CompoundFactStrategy input = (CompoundFactStrategy)StrategyFactory.determineStrategy("abcd Silver is 20 Credits");
        Assert.assertNotNull(input);
    }

    @Test
    public void testQuestion() {
        QuestionStrategy input = (QuestionStrategy)StrategyFactory.determineStrategy("how much is abcd abcd ?");
        Assert.assertNotNull(input);
    }
    

    @Test
    public void testBadInput() {
        BadInputStrategy input = (BadInputStrategy)StrategyFactory.determineStrategy("how much distance from Washington D.C. to Miami beach ?");
        Assert.assertNotNull(input);
    }
}
