import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListGenerator {
    private int[] ints;

    public ListGenerator(int c) {
        ints = toSimpleArray(generate(c));
    }

    private List<Integer> generate(int c){
        return Stream.generate(() -> new Random().nextInt(100)).limit(c).collect(Collectors.toList());
    }

    private int[] toSimpleArray(List<Integer> list){
        ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public int[] getInts() {
        return ints;
    }

    public static int[][] getRankedInts(int worldSize, int[] ints){
        int rankSize = ints.length/worldSize;
        int[][] ints1 = new int[worldSize][rankSize];
        for (int i =0, x = 0; i < worldSize; i++, x+=rankSize) {
            if (rankSize >= 0) System.arraycopy(ints, 0 + x, ints1[i], 0, rankSize);
        }
        return ints1;
    }
}
