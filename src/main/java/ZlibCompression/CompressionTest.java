

public class CompressionTest
{
    public static void main(String[] args)
    {
        Compressor compressor = new Compressor();

        String stringToCompress = "20";
        //String stringToCompress = "When in the course of human events, it becomes necessary for one people to dissolve the bands that bind them...";
        System.out.println("stringToCompress is: '" + stringToCompress + "'");
        byte[] bytesCompressed = compressor.compress(stringToCompress);
        System.out.println("bytesCompressed is: ");
        Console.writeBytesAsHexadecimal(bytesCompressed);
        String stringDecompressed = compressor.decompressToString(bytesCompressed);
        System.out.println("stringDecompressed is: '" + stringDecompressed + "'");
    }
}