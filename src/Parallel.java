import Sorting.MergeSort;
import helpers.ListGenerator;
import mpi.MPI;
import java.util.Arrays;
public class Parallel {
    public static void main(String[] args) {
        long timeStart= System.currentTimeMillis();

        // Init MPI
        MPI.Init(args);
        // rank - number of process
        // size - quantities of process
        int rank = MPI.COMM_WORLD.Rank(), size = MPI.COMM_WORLD.Size(), root = 0;
        // length - length of array which we wanna sort
        // unitSize - length of one process
        int length = ListGenerator.getLength(), unitSize = length / size;
        // send - what we send from root to all
        // recv -what we receive from root
        // newrecv - what we receive in root from all
        int[] sendBuffer = new int[length], recvBuffer = new int[unitSize], newRecBuffer = new int[length];


        if(rank == root){
            // generate random array
            sendBuffer = new ListGenerator(length).getInts();
            System.out.printf("Shuffled: %s \n", Arrays.toString(sendBuffer));
        }

        // sending parts of sendBuffer to all process
        MPI.COMM_WORLD.Scatter(sendBuffer, 0, unitSize, MPI.INT, recvBuffer, 0, unitSize, MPI.INT, root);

        // sort in each process
        recvBuffer = MergeSort.sortArray(recvBuffer);

        // assembly all parts to one array
        MPI.COMM_WORLD.Gather(recvBuffer, 0, unitSize, MPI.INT, newRecBuffer, 0, unitSize, MPI.INT, root);

        if (rank == root) {
            // finally merge
//            int[][] result = Sorting.MergeSort.spliting(helpers.ListGenerator.getRankedInts(size, newRecBuffer));
//            System.out.printf("Sorted   :%s \n", Arrays.toString(result[0]));
            System.out.printf("Sorted   :%s \n", Arrays.toString(MergeSort.sortArray(newRecBuffer)));

            // check time
            long timeStop = System.currentTimeMillis();
            System.out.printf("Time is: %d ms", timeStop - timeStart);
        }
        // finalization for garbage collector
        MPI.Finalize();
    }
}
