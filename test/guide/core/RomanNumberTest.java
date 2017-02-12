package guide.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RomanNumberTest {
    private CalcManager instance;
    
    @Before public void setUp() { this.instance = CalcManager.getInstance(); }

    @Test public void test_I_1()        { Assert.assertEquals(1d, instance.calculateNumber("I"), 0d); }
    @Test public void test_V_5()        { Assert.assertEquals(5d, instance.calculateNumber("V"), 0d); }
    @Test public void test_X_10()       { Assert.assertEquals(10d, instance.calculateNumber("X"), 0d); }
    @Test public void test_L_50()       { Assert.assertEquals(50d, instance.calculateNumber("L"), 0d); }
    @Test public void test_C_100()      { Assert.assertEquals(100d, instance.calculateNumber("C"), 0d); }
    @Test public void test_D_500()      { Assert.assertEquals(500d, instance.calculateNumber("D"), 0d); }
    @Test public void test_M_1000()     { Assert.assertEquals(1000d, instance.calculateNumber("M"), 0d); }
    
    @Test public void test_II_2()       { Assert.assertEquals(2d, instance.calculateNumber("II"), 0d); }
    @Test public void test_XX_20()      { Assert.assertEquals(20d, instance.calculateNumber("XX"), 0d); }
    @Test public void test_CC_200()     { Assert.assertEquals(200d, instance.calculateNumber("CC"), 0d); }
    @Test public void test_MM_2000()    { Assert.assertEquals(2000d, instance.calculateNumber("MM"), 0d); }
    
    @Test(expected=IllegalArgumentException.class) public void test_IIII_exception() { instance.calculateNumber("IIII"); }
    @Test(expected=IllegalArgumentException.class) public void test_XXXX_exception() { instance.calculateNumber("XXXX"); }
    @Test(expected=IllegalArgumentException.class) public void test_CCCC_exception() { instance.calculateNumber("CCCC"); }
    @Test(expected=IllegalArgumentException.class) public void test_MMMM_exception() { instance.calculateNumber("MMMM"); }
    
    @Test(expected=IllegalArgumentException.class) public void test_VV_exception() { instance.calculateNumber("VV"); }
    @Test(expected=IllegalArgumentException.class) public void test_LL_exception() { instance.calculateNumber("LL"); }
    @Test(expected=IllegalArgumentException.class) public void test_DD_exception() { instance.calculateNumber("DD"); }
    
    @Test public void test_IV_4() { Assert.assertEquals(4d, instance.calculateNumber("IV"), 0d); }
    @Test public void test_IX_9() { Assert.assertEquals(9d, instance.calculateNumber("IX"), 0d); }
    @Test public void test_XL_40() { Assert.assertEquals(40d, instance.calculateNumber("XL"), 0d); }
    @Test public void test_XC_90() { Assert.assertEquals(90d, instance.calculateNumber("XC"), 0d); }
    @Test public void test_CD_400() { Assert.assertEquals(400d, instance.calculateNumber("CD"), 0d); }
    @Test public void test_CM_900() { Assert.assertEquals(900d, instance.calculateNumber("CM"), 0d); }
    
    @Test(expected=IllegalArgumentException.class) public void test_IIV_exception() { instance.calculateNumber("IIV"); }
    @Test(expected=IllegalArgumentException.class) public void test_IIX_exception() { instance.calculateNumber("IIX"); }
    @Test(expected=IllegalArgumentException.class) public void test_XXL_exception() { instance.calculateNumber("XXL"); }
    @Test(expected=IllegalArgumentException.class) public void test_XXC_exception() { instance.calculateNumber("XXC"); }
    @Test(expected=IllegalArgumentException.class) public void test_CCD_exception() { instance.calculateNumber("CCD"); }
    @Test(expected=IllegalArgumentException.class) public void test_CCM_exception() { instance.calculateNumber("CCM"); }
    
    @Test public void test_XIV_14() { Assert.assertEquals(14d, instance.calculateNumber("XIV"), 0d); }
    @Test public void test_XIX_19() { Assert.assertEquals(19d, instance.calculateNumber("XIX"), 0d); }
    @Test public void test_CXL_140() { Assert.assertEquals(140d, instance.calculateNumber("CXL"), 0d); }
    @Test public void test_CXC_190() { Assert.assertEquals(190d, instance.calculateNumber("CXC"), 0d); }
    @Test public void test_MCD_1400() { Assert.assertEquals(1400d, instance.calculateNumber("MCD"), 0d); }
    @Test public void test_MCM_1900() { Assert.assertEquals(1900d, instance.calculateNumber("MCM"), 0d); }
    
    @Test(expected=IllegalArgumentException.class) public void test_XIIV_exception() { instance.calculateNumber("XIIV"); }
    @Test(expected=IllegalArgumentException.class) public void test_XIIX_exception() { instance.calculateNumber("XIIX"); }
    @Test(expected=IllegalArgumentException.class) public void test_CXXL_exception() { instance.calculateNumber("CXXL"); }
    @Test(expected=IllegalArgumentException.class) public void test_CXXC_exception() { instance.calculateNumber("CXXC"); }
    @Test(expected=IllegalArgumentException.class) public void test_MCCD_exception() { instance.calculateNumber("MCCD"); }
    @Test(expected=IllegalArgumentException.class) public void test_MCCM_exception() { instance.calculateNumber("MCCM"); }
    
    @Test(expected=IllegalArgumentException.class) public void test_XVX_exception() { instance.calculateNumber("XVX"); }
    @Test(expected=IllegalArgumentException.class) public void test_CLC_exception() { instance.calculateNumber("CLC"); }
    @Test(expected=IllegalArgumentException.class) public void test_MDM_exception() { instance.calculateNumber("MDM"); }

    @Test public void test_MMMCMXCIX_3999() { Assert.assertEquals(3999d, instance.calculateNumber("MMMCMXCIX"), 0d); }
    
    @Test(expected=IllegalArgumentException.class) public void test_IXX_exception() { instance.calculateNumber("IXX"); }
    @Test(expected=IllegalArgumentException.class) public void test_IXL_exception() { instance.calculateNumber("IXL"); }
    @Test(expected=IllegalArgumentException.class) public void test_IXI_exception() { instance.calculateNumber("IXI"); }
}
