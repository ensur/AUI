import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test_Shift {
    Shift shift = new Shift();
//тесты
    @Test
    public void TestShiftPositive1(){
        assertTrue(shift.testShift("abcde", "edcba"));
    }
    @Test
    public void TestShiftPositive2(){
        assertTrue(shift.testShift("abcde ", "ed cba"));
    }
    @Test
    public void TestShiftPositive3(){
        assertTrue(shift.testShift("^%#@", "@#^%"));
    }
    @Test
    public void TestShiftNegative1(){
        assertTrue(shift.testShift("abcdeg ", "ed cba"));
    }
    @Test
    public void TestShiftNegative2(){
        assertTrue(shift.testShift("abc^%^&$(*deg ", "ed cb&*$^#%a"));
    }

    @Test(expected = AssertionError.class)//ну и делаем тест с ожиданием эксепшена
    public void TestShiftNegative3() throws AssertionError {
       // try {
            assertTrue(shift.testShift("H", "#U+0048"));
            Assert.fail("excepted Assertion exception");
       // }catch(AssertionError thrown){//тут я пытался сделать блок catch чтобы он ловил ошибки неподходящего типа, но что то не получилось...
           // Assert.assertNotEquals("java.lang.AssertionError", thrown.getMessage());
       // }


        }


}
