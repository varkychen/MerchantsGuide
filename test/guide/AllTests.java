package guide;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import guide.core.CalcManagerTest;
import guide.core.CompoundFactStrategyTest;
import guide.core.MerchantsGuideTest;
import guide.core.RomanNumberTest;
import guide.core.StrategyFactoryTest;
import guide.strategy.FactStrategyTest;

@RunWith(Suite.class)
@SuiteClasses({ StrategyFactoryTest.class, 
                MerchantsGuideTest.class,
                FactStrategyTest.class, 
                CompoundFactStrategyTest.class,
                CalcManagerTest.class,
                RomanNumberTest.class})
public class AllTests {
}
