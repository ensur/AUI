import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Test_Count {
    Count count = new Count();

    @Test
    public void positive_1(){
        int[] mas = {12, 23, 23, 35, 83};//ну и тесты с использованием хамкреста
        assertThat( count.getThreeNumberCount(mas), is(4));
        }
    @Test
    public void positive_2(){
        int[] mas = {333, 33, 3, 3333, 0000};
        assertThat( count.getThreeNumberCount(mas), is(10));
    }
    @Test(expected = ArithmeticException.class)
    public void negative_1(){
            int[] mas = {0003, 0, 3*11/0,0000};
        assertThat("На ноль делить нельзя", count.getThreeNumberCount(mas), is(1));
    }
    @Test
    public void negative_2(){
        int[] mas = {23, 234,(int) Math.sqrt(-33)};
        assertThat( count.getThreeNumberCount(mas), is(2));
    }
    }
