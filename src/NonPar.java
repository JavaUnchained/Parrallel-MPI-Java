import java.util.Arrays;

public class NonPar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sortArray(new ListGenerator(100).getInts())));
    }
}
