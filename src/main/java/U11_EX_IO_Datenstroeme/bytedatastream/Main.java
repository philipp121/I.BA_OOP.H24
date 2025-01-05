package U11_EX_IO_Datenstroeme.bytedatastream;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.bin";
        DataHandler dataHandler = new DataHandler(filePath);

        // Write and Read a Single Integer
        dataHandler.writeInt(12345);
        int intValue = dataHandler.readInt();
        System.out.println("Read integer: " + intValue);

        //Write and Read Mixed Data Types
        dataHandler.writeMixedData(42, 3.14f, 'A', 123.456);
        System.out.println("Reading mixed data types:");
        dataHandler.readMixedData();
    }
}
