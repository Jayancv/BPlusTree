package FibonacciCompression;

import java.io.*;
import java.util.ArrayList;

public class FibonacciCodder {

    ArrayList<Integer> fibList = new ArrayList<Integer>();

    private int getFibonacciSequence(int key) {

        fibList.add(1);
        fibList.add(2);
        int incrementor = 0;
        for (incrementor = 2; incrementor <= key; ++incrementor) {
            if (fibList.get(incrementor - 1) == key) {
                incrementor = incrementor - 1;
                break;
            } else if (fibList.get(incrementor - 1) > key) {
                fibList.remove(incrementor - 1);
                incrementor = incrementor - 2;
                break;
            } else {
                fibList.add(fibList.get(incrementor - 1) + fibList.get(incrementor - 2));
            }
        }
//        System.out.println(fibList);
//        System.out.println(incrementor);
        return incrementor;
    }

    public String createFibonacciCode(int key) {

        if (key == 1) {
            return "11";
        } else {
            int index = getFibonacciSequence(key);
            int i = index;
            char[] charSequence = new char[index + 2];

            while (key > 0) {
                charSequence[i] = '1';

                key = key - fibList.get(i);

                i = i - 1;

                while (i >= 0 && fibList.get(i) > key) {
                    charSequence[i] = '0';
                    i = i - 1;
                }
            }
            charSequence[index + 1] = '1';
            return new String(charSequence);
        }
    }


    public void write(Object object) throws IOException {
        //Write to database

        File fout = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        //bw.write(object.toString());
        System.out.println(object.toString());
        bw.append(object.toString().subSequence(0, object.toString().length()));
        bw.newLine();

        bw.close();
    }

//    private void compressionLeafNode(Node node) throws IOException {
//        write(node.key.get(0));          //  Write 1st element in the leaf node to DB
//
//        for (int i = 1; i < node.getCount(); i++) {
//            int aa = node.key.get(i) - node.key.get(i - 1);
//            String num = createFibonacciCode(aa);
//            write(num);                    // Write compressed value of different between two values
//        }
//    }
//
//    private void compressionNode(Node node) throws IOException {         //compress internal nodes
//        write(node.key.get(0));          //  Write 1st element in the leaf node to DB
//
//        for (int i = 1; i < node.getCount(); i++) {
//            String num = createFibonacciCode(node.key.get(i) - node.key.get(i - 1));
//            write(num);
//        }
//        write(node.link);
//    }
//
//    private void compression(Node node) throws IOException {
//
//        if (node.isLeaf) {
//            compressionLeafNode(node);
//        } else {
//            compressionNode(node);
//        }
//    }
//
//    public boolean compressionTest(Node node) throws IOException {
//        int temp = 0;
//        int page = 1;
//
//        compression(node);
//
//        if (temp > page) {
//            return false;
//        } else {
//            return true;
//        }
//    }

//    public static void main(String[] args) throws IOException {

//        Node node = new Node();
//        node.key.add(5);
//        node.key.add(20);
//        node.key.add(35);
//        node.link.add(0);
//        node.link.add(10);
//        node.link.add(100);
//        node.link.add(1000);
//
//        Node node1 = new Node();
//        node1.isLeaf = true;
//        node1.key.add(1);
//        node1.key.add(2);
//        node1.key.add(3);
//        node1.key.add(4);

//        boolean done = new FibonacciCodder().compressionTest(node);
//        System.out.println("--------------");
//        boolean done1 = new FibonaccCodder().compressionTest(node1);


//
//    }
}
