package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {


    // merge sorting
    public static int [] sortArray(int[] arrayA){
        if (arrayA == null || arrayA.length < 2) {
            return arrayA;
        }

        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB, arrayC);
    }

    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] b = new int[a1.length + a2.length];
        int positionA1 = 0;
        int positionA2 = 0;

        for(int i = 0; i < b.length; i++) {
            if(positionA1 == a1.length){
                b[i] = a2[positionA2];
                positionA2++;
            } else if(positionA2 == a2.length){
                b[i] = a1[positionA1];
                positionA1++;
            } else if(a1[positionA1] < a2[positionA2]){
                b[i] = a1[positionA1];
                positionA1++;
            } else {
                b[i] = a2[positionA2];
                positionA2++;
            }
        }
        return b;
    }

    public static int[] finMerge(int [] ... arrs) {
        if (arrs.length == 2) {
            return mergeArray(arrs[0], arrs[1]);
        }
        int[][] narr1 = new int[1][arrs.length / 2];
        int[][] narr2 = new int[1][arrs.length / 2];

        for (int i = 0; i < arrs.length/2; i++) {
            narr1[0][i] = arrs[0][i];
        }
        for (int i = arrs.length/2, j = 0; i < arrs.length-1; i++, j++) {
            narr2[0][j] = arrs[0][i];
        }
        return finMerge(narr1[0], narr2[0]);
    }

    // for final merge]
    public static int[][] spliting(int [][] subArr){
        if (subArr.length == 1) {
            return subArr;
        }

        int[][] arr = new int[subArr.length/2][subArr[0].length * 2];

        for (int i = 0, j = 0; i < subArr.length; i+=2, j++) {

        }

        return spliting(arr);
    }
}