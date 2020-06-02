package Sorting;

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

    // for final merge
    public static int[][] spliting(int [][] subArr){
        if (subArr.length == 1) {
            return subArr;
        }

        int[][] arr = new int[subArr.length/2][subArr[0].length * 2];

        for (int i = 0, j = 0; i < subArr.length; i+=2, j++) {
            arr[j] = mergeArray(subArr[i], subArr[i + 1]);
        }

        return spliting(arr);
    }
}