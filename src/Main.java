import mpi.MPI;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank(), size = MPI.COMM_WORLD.Size(), root = 0;

        int length = 16, unitSize = length / size;

        int[] sendBuffer = new int[length], recvBuffer = new int[unitSize], newRecBuffer = new int[length];

        if(rank == root){
            sendBuffer = new ListGenerator(length).getInts();
            System.out.println(Arrays.toString(sendBuffer));
        }

        MPI.COMM_WORLD.Scatter(sendBuffer, 0, unitSize, MPI.INT, recvBuffer, 0, unitSize, MPI.INT, root);

        recvBuffer = new MergeSort().sortArray(recvBuffer);

        MPI.COMM_WORLD.Gather(recvBuffer, 0, unitSize, MPI.INT, newRecBuffer, 0, unitSize, MPI.INT, root);
        if (rank == root) {
            int[][] result = new MergeSort().spliting(ListGenerator.getRankedInts(size, newRecBuffer));
            System.out.println("Proccess root have all array: " + Arrays.toString(result[0]));
        }
        MPI.Finalize();
    }
}
