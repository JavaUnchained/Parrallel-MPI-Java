package tests;

import Sorting.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTests {

    private static  final int[] ORDERED = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};        // упорядоченный
    private static  final int[] REVERS_ORDERED = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}; // обратно
    private static  final int[] ALL_THE_SAME = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};          // Все числа одинаковы
    private static  final int[] TWO_NEAR = {2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1};          // Два ближних числа
    private static  final int[] TWO_NEAR_2 = {1,2};                                                    // Два ближних числа
    private static  final int[] TWO_NEAR_3 = {2,1};                                                    // Два ближних числа
    private static  final int[] ONE_ELEM = {1};                                                        // Один элемент
    private static  final int[] EMPTY_ELEM = {};                                                       // Пустой элемент
    private static  final int[] NULL_ELEM = null;                                                      // Пустой элемент


    @Test
    public void empty(){
       Assert.assertArrayEquals(new int[]{}, EMPTY_ELEM);
    }

    @Test
    public void nullArr(){
        Assert.assertNull(MergeSort.sortArray(NULL_ELEM));
    }
    @Test
    public void oneElement(){
        Assert.assertArrayEquals(new int[]{1}, MergeSort.sortArray(ONE_ELEM));
    }
    @Test
    public void nears(){
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2}, MergeSort.sortArray(TWO_NEAR));
        Assert.assertArrayEquals(new int[]{1,2}, MergeSort.sortArray(TWO_NEAR_2));
        Assert.assertArrayEquals(new int[]{1,2}, MergeSort.sortArray(TWO_NEAR_3));
    }

    @Test
    public void same(){
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, MergeSort.sortArray(ALL_THE_SAME));
    }

    @Test
    public void oredered(){
        MergeSort.sortArray(ORDERED);
        Assert.assertArrayEquals(ORDERED, MergeSort.sortArray(ORDERED));
    }
    @Test
    public void reversOrdered(){
        Assert.assertArrayEquals(ORDERED, MergeSort.sortArray(REVERS_ORDERED));
    }
}
