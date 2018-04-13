import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test_Shift {
    Shift shift = new Shift();
//тесты
    @Test
    public void TestShiftPositive1(){
        assertTrue("Неверные данные",shift.testShift("abcde", "edcba"));
    }
    @Test
    public void TestShiftPositive2(){

        assertTrue("Неверные данные",shift.testShift("abcde ", "ed cba"));
    }
    @Test
    public void TestShiftPositive3(){
        assertTrue("Неверные данные",shift.testShift("^%#@", "@#^%"));
    }
    @Test(expected = AssertionError.class)
    public void TestShiftNegative1(){
        assertTrue("Неверные данные",shift.testShift("abcdeg ", "ed cba"));
    }
    @Test(expected = AssertionError.class)
    public void TestShiftNegative2(){
        assertTrue("Неверные данные",shift.testShift("abc^%^&$(*deg ", "ed cb&*$^#%a"));
    }

    @Test(expected = AssertionError.class)//ну и делаем тест с ожиданием эксепшена
    public void TestShiftNegative3(){
            assertTrue("Неверные данные",shift.testShift("H", "#U+0048"));
    }


}
