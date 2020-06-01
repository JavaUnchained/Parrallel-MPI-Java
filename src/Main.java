import mpi.MPI;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MPI.Init(args);
//        int rank = MPI.COMM_WORLD.Rank();
//        int size = MPI.COMM_WORLD.Size();
//
//        int unitsize=4;
//        int root = 0;
//        int send_buffer[] = null;
//        send_buffer = new int[unitsize * size];
//        int recv_buffer[] = new int[unitsize];
//        int new_recv_buffer[] = new int[unitsize * size];
//        MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recv_buffer,0,unitsize, MPI.INT,root);
//        if (rank != root) {
//            for (int i = 0; i < unitsize; i++) {
//                recv_buffer[i] = rank;
//            }
//        }
//
//        MPI.COMM_WORLD.Gather(recv_buffer,0,unitsize,MPI.INT,new_recv_buffer,0, unitsize, MPI.INT, root);
//
//        if (rank == root) {
//            for (int i = 0; i < (unitsize * size) ; i++) {
//                System.out.print(new_recv_buffer[i] + " ");
//            }
//        }
//
//        MPI.Finalize();

//        Init
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int root = 0;

        int length = 16;
        int unitsize = length / size;

        int[] sendBuffer = null;
        sendBuffer = new int[length];
        int[] recvBuffer = new int[unitsize];
        int[] newRecBuffer = new int[length];

        if(rank == root){
            sendBuffer = new ListGenerator(length).getInts();
            System.out.println(Arrays.toString(sendBuffer));
        }
        MPI.COMM_WORLD.Scatter(sendBuffer, 0, unitsize, MPI.INT, recvBuffer, 0, unitsize, MPI.INT, root);

        recvBuffer = new MergeSort().sortArray(recvBuffer);


        MPI.COMM_WORLD.Gather(recvBuffer, 0, unitsize, MPI.INT, newRecBuffer, 0, unitsize, MPI.INT, root);
        if (rank == root) {
            int[][] result = new MergeSort().spliting(ListGenerator.getRankedInts(size, newRecBuffer));
            System.out.println("Proccess root have all array: " + Arrays.toString(result[0]));
        }

        MPI.Finalize();


//        Long start = System.currentTimeMillis();
//        MergeSort mergeSort = new MergeSort();
//        Long finish = System.currentTimeMillis();
//        System.out.printf("Current time is %d ms",finish - start);
//        int[] ints = new ListGenerator(22).getInts();
//        int[] array1 = { 8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43 };
//        int[] result = MergeSort.mergesort(ints);
//        System.out.println(Arrays.toString(MergeSort.a)); // до сортировки
//        MergeSort.sort(0, MergeSort.a.length - 1);               // сртировка
//        System.out.println(Arrays.toString(MergeSort.a)); // после сортировки

//        int[] originalArray = new ListGenerator(22).getInts();




        // Init MPI
//        MPI.Init(args);
//        int rank = MPI.COMM_WORLD.Rank();
//        int worldSize = MPI.COMM_WORLD.Size();
//
//        //Set Root process
//        int rootProcess = 0;
//
//        // Делим массив на равные куски
//        int size = originalArray.length/worldSize;
//        int[] subArray = new int[size];
//        MPI.COMM_WORLD.Scatter(originalArray, size, 1, MPI.INT, subArray, size, 0 , MPI.INT, rootProcess);
//
//        MergeSort mergeSort= new MergeSort(originalArray);
//        mergeSort.merge(0, subArray.length - 1);
//        int[] sorted = null;
//        if(rank == 0){
//            sorted = new int[originalArray.length];
//        }
//
//        MPI.COMM_WORLD.Gather(subArray, size, 1, MPI.INT, sorted, size, 1, MPI.INT, rootProcess);
//        // final merge
//        if (rank == 0){
//            mergeSort.setA(sorted);
//            mergeSort.merge(0, subArray.length - 1);
//        }
//        MPI.COMM_WORLD.Barrier();
//        MPI.Finalize();

//        System.out.println(Arrays.toString(MergeSort.a)); // до сортировки
//        MergeSort.sort(0, MergeSort.a.length - 1);               // сртировка
//        System.out.println(Arrays.toString(MergeSort.a)); // после сортировки
//        MPI.COMM_WORLD.Gather(ints, ints.length, MPI.INT, );
//        System.out.printf("Before - %s %n After - %s %n %n", Arrays.toString(ints), Arrays.toString(result));
//        System.out.println("Will: " + Arrays.toString(result));

    }

}
