package guide.core;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guide.commands.AnswerCommand;
import guide.commands.NoOpCommand;


public class MerchantsGuideTest {

    private MerchantsGuide guide;

    @Before
    public void setUp() {
        guide = new MerchantsGuide();
        CalcManager.getInstance().reset();
    }

    @Test
    public void testReadInputData() {
        String test="abcd is I";
        guide.readInput(test);
        Assert.assertEquals(1, CalcManager.getInstance().table.size());
        assertMeasure("abcd", "I", null, 1.0d);
    }
    

    @Test
    public void testDigits() {
        String[] test={ "abcd is I",
                        "bcde is V",
                        "cdef is X",
                        "defg is L",
                        "efgh is C",
                        "fghi is D",
                        "ghij is M",
                      };
        Arrays.stream(test).forEach(guide::readInput);
        Assert.assertEquals(7, CalcManager.getInstance().table.size());
        assertMeasure("abcd", "I", null, 1.0d);
        assertMeasure("bcde", "V", null, 5.0d);
        assertMeasure("cdef", "X", null, 10.0d);
        assertMeasure("defg", "L", null, 50.0d);
        assertMeasure("efgh", "C", null, 100.0d);
        assertMeasure("fghi", "D", null, 500.0d);
        assertMeasure("ghij", "M", null, 1000.0d);
    }

    private void assertMeasure(String numeral, String symbol, String unit, double value) {
        Measure measure = CalcManager.getInstance().table.get(numeral);
        Assert.assertEquals(symbol, measure.getSymbol());
        Assert.assertNull(measure.getUnits());
        Assert.assertEquals(value, measure.getValue(), 0d);
    }
    
    @Test
    public void testReadQuestion() {
        String fact="abcd is I";
        String question = "how much is abcd abcd ?";
        guide.readInput(fact);
        guide.readInput(question);
        
        Assert.assertEquals(1, CalcManager.getInstance().table.size());
        assertMeasure("abcd", "I", null, 1.0d);
        Assert.assertEquals(2, guide.commands.size());
        Assert.assertTrue(guide.commands.get(0) instanceof NoOpCommand);
        
        AnswerCommand answer = (AnswerCommand)guide.commands.get(1);
        Assert.assertEquals(2d, answer.getAnswer().getValue(), 0d);
    }

}
