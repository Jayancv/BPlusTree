package ZlibCompression;

class Console
{
    public static void writeBytesAsHexadecimal(byte[] bytesToWrite)
    {
        int numberOfBytes = bytesToWrite.length;
        int bytesPerLine = 16;
        int bytesPerColumn = 8;
        int numberOfColumns = bytesPerLine / bytesPerColumn;
        int linesPerBlock = 16;

        int numberOfLines = (int)Math.ceil
                (
                        (double)numberOfBytes / (double)bytesPerLine
                );

        int widthOfDataOnDisplayInChars =
                numberOfColumns
                        * (bytesPerColumn * 3 + 1)
                        - 1;

        String horizontalRule = "";

        for (int i = 0; i < widthOfDataOnDisplayInChars; i++)
        {
            horizontalRule += "=";
        }

        System.out.println(horizontalRule);

        for (int y = 0; y < numberOfLines; y++)
        {
            if (y > 0 && y % linesPerBlock == 0)
            {
                System.out.println("");
            }

            int bytesOnThisLine;

            if (y < numberOfLines - 1)
            {
                bytesOnThisLine = bytesPerLine;
            }
            else
            {
                bytesOnThisLine = numberOfBytes % bytesPerLine;
            }

            for (int x = 0; x < bytesOnThisLine; x++)
            {
                if (x > 0 && x % bytesPerColumn == 0)
                {
                    System.out.print("  ");
                }

                int byteIndex = y * bytesPerLine + x;
                byte byteCurrent = bytesToWrite[byteIndex];

                String byteAsString = Integer.toHexString(byteCurrent & 0xFF);
                if (byteAsString.length() < 2)
                {
                    byteAsString = "0" + byteAsString;
                }

                byteAsString += " ";

                System.out.print(byteAsString);
            }

            System.out.println();
        }

        System.out.println(horizontalRule);
    }
}