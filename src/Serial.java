import Sorting.MergeSort;
import helpers.ListGenerator;

import java.util.Arrays;

public class Serial {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] shuf = new ListGenerator(20_000_000).getInts();
        int[] sort = MergeSort.sortArray(shuf);
        System.out.printf("Shuffled: %s \n",Arrays.toString(shuf));
        System.out.printf("Sorted  : %s \n", Arrays.toString(sort));

        long finishTime = System.currentTimeMillis();
        System.out.printf("Time is : %d ms", finishTime - startTime);
    }
}
