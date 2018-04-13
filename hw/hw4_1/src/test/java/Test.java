import category.Test_group_eq;
import category.Test_group_is;
import category.Test_group_rec;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertTrue;


public class Test {
    Trangle test = new Trangle();



    @Category(Test_group_eq.class)//тут мы добавляем категории для того чтобы в POM могли поменять конфигурацию
    //и запустить нужную нам, для этого и создали интерфейсы для каждого теста

    @org.junit.Test(expected = AssertionError.class)
    public void findEq(){

    assertTrue("Треугольник не равнобедренный",(test.l1==test.l2)||(test.l2==test.l3));

    }
    @Category(Test_group_is.class)
    @org.junit.Test(expected = AssertionError.class)
    public void findIs(){

           assertTrue("Треугольник не равносторонний",(test.l1 == test.l2) && (test.l1 == test.l3) && (test.l2 == test.l3));

    }
    @Category(Test_group_rec.class)
    @org.junit.Test(expected = AssertionError.class)
    public void findRec(){

       assertTrue("Треугольник не прямоугольный",(Math.pow(test.l1,2)==(Math.pow(test.l2,2)+Math.pow(test.l3,2)))||(Math.pow(test.l2,2)==(Math.pow(test.l1,2)+Math.pow(test.l3,2)))||(Math.pow(test.l3,2)==(Math.pow(test.l2,2)+Math.pow(test.l1,2))));


    }


}
