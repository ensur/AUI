import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shift {
    public boolean testShift(String s1, String s2){
        List<String> l1 = Arrays.stream(s1.split(""))//загояем отсортерованную строку в лис
                .sorted()
                .collect(Collectors.toList());
        List<String> l2 = Arrays.stream(s2.split(""))//тут аналогично
                .sorted()
                .collect(Collectors.toList());
        return l1.equals(l2);//и сравниваем листы)

    }
}
