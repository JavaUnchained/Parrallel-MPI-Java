import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListGenerator {
    private int c;
    List<Integer> list;
    int[] ints;

    public ListGenerator(int c) {
        this.list = generate(c);
        ints = toSimpleArray(this.list);
    }

    private List<Integer> generate(int c){
        return Stream.generate(() -> new Random().nextInt(100)).limit(c).collect(Collectors.toList());
    }

    public int[] toSimpleArray(List<Integer> list){
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
            for (int j = 0; j < rankSize; j++) {
                ints1[i][j] = ints[j+x];
            }
        }
        return ints1;
    }

    public List<Integer> getList() {
        return list;
    }

}
