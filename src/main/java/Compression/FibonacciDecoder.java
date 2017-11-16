package Compression;

public class FibonacciDecoder {

    static int n1 = 0, n2 = 1, n3 = 0, index = 0, sum = 0;

    private void fibonacci(int count, String code) {
        if (count > 0) {

            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            if (code.charAt(index)=='1'){
                sum=sum+n3;
            }
            index++;
            fibonacci(count - 1,code);
        }

    }

    public int getRealValue(String code) {
        int count = code.length() - 1;
        fibonacci(count, code.substring(0, count));
        return sum;
    }
}
