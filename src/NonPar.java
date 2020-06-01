import java.util.Arrays;

public class NonPar {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] shuf = new ListGenerator(40_000_000).getInts();
        int[] sort = MergeSort.sortArray(shuf);
        System.out.printf("Shuffled: %s \n",Arrays.toString(shuf));
        System.out.printf("Sorted  : %s \n", Arrays.toString(sort));

        long finishTime = System.currentTimeMillis();
        System.out.printf("Time is : %d ms", finishTime - startTime);
    }
}
