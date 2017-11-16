
public class DatabaseTest {

    public static void main(String[] args) {
        BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>();
        Integer[] inputKey = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 0, 34, 35, 36, 37, 39, 77, 55, 72, 30};
        Integer[] inputValues = new Integer[]{90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119};
        Utils.bulkInsert(tree, inputKey, inputValues);
        String output = Utils.outputTree(tree);
        System.out.println(output);
    }
}
