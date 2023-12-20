import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hi, in this project I'm learning Java");
        List<Integer> list_int = Arrays.asList(1,2,3,4,5);
        list_int = list_int.stream().filter(el -> { return !(el%2==0);}).collect(Collectors.toList());
        System.out.println(list_int);
        
    }
}