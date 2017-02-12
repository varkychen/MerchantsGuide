package guide.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guide.commands.AnswerCommand;
import guide.strategy.CompoundFactStrategy;
import guide.strategy.FactStrategy;
import guide.strategy.QuestionStrategy;

public class QuestionStrategyTest {

    @Before
    public void setUp() throws Exception {
        CalcManager.getInstance().handle(new FactStrategy("abcd is I"));
        CalcManager.getInstance().handle(new CompoundFactStrategy("abcd Silver is 5 Metal"));
    }

    @Test
    public void testInvokeNumberQuestion() {
        QuestionStrategy questionStrategy = new QuestionStrategy("how much is abcd abcd ?");
        AnswerCommand command = questionStrategy.invoke(CalcManager.getInstance().table);
        Measure answer = new Measure("II", null, 2d);
        Assert.assertEquals(answer, command.getAnswer());
    }

    @Test
    public void testInvokeUnitQuestion() {
        QuestionStrategy questionStrategy = new QuestionStrategy("how many Metals is abcd abcd Silver?");
        AnswerCommand command = questionStrategy.invoke(CalcManager.getInstance().table);
        Measure answer = new Measure(null, "Metal", 10d);
        Assert.assertEquals(answer, command.getAnswer());
    }

}
