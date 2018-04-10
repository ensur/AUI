import static java.lang.Math.abs;

public class Count {
    int numbers[] = {22,33,45,66,23,54,18};




    public int getThreeNumberCount(int[] numbers) {
        int count =0;
       for(int i=0;i<numbers.length;i++){//тут дедовский алгоритм подсчета, если честно
           //долго думал как сделать красиво, но ни через стримы ни через что либо другое не получилось
           int a=abs(numbers[i]);
           while(a!=0){
               if(a%10==3) count++;
               a=a/10;
           }
       }
        return count;
    }
        }

