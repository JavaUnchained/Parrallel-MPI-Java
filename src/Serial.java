import Sorting.MergeSort;
import helpers.ListGenerator;

import java.util.Arrays;

public class Serial {
    public static void main(String[] args) {
        int length = ListGenerator.getLength();

        int[] shuf = new ListGenerator(length).getInts();
        long startTime = System.currentTimeMillis();
        int[] sort = MergeSort.sortArray(shuf);
//        System.out.printf("Shuffled: %s \n",Arrays.toString(shuf));
//        System.out.printf("Sorted  : %s \n", Arrays.toString(sort));
        System.out.println("Sorted " + sort.toString());
        long finishTime = System.currentTimeMillis();
        System.out.printf("Time is : %d ms", finishTime - startTime);
    }
}
