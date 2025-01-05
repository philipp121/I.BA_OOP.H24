package U11_EX_IO_Datenstroeme.bytedatastream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class DataHandler {

    private static final Logger LOG = LoggerFactory.getLogger(DataHandler.class);
    private final String filePath;

    public DataHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method to write a single integer
     * @param value the int value to write into file
     */
    public void writeInt(int value) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(value);
        } catch (IOException e) {
            LOG.error("Failed to write data to file '{}'", filePath, e);
        }
    }

    /**
     * Method to read a single integer from a file. Returns -1 if an exception occurs
     * @return the int value that was read
     */
    public int readInt() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            return dis.readInt();
        } catch (IOException e) {
            LOG.error("Failed to read from file '{}'", filePath, e);
            return -1;
        }
    }

    /**
     * Method to write multiple data types into a file
     * @param intValue an int Value to write
     * @param floatValue a float Value to write
     * @param charValue a char Value to write
     * @param doubleValue a double Value to write
     */
    public void writeMixedData(int intValue, float floatValue, char charValue, double doubleValue) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(intValue);
            dos.writeFloat(floatValue);
            dos.writeChar(charValue);
            dos.writeDouble(doubleValue);
        } catch (IOException e) {
            LOG.error("Failed to write data to file '{}'", filePath, e);
        }
    }

    /**
     * Method to read multiple data types from a file
     */
    public void readMixedData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int intValue = dis.readInt();
            float floatValue = dis.readFloat();
            char charValue = dis.readChar();
            double doubleValue = dis.readDouble();

            System.out.println("Int: " + intValue);
            System.out.println("Float: " + floatValue);
            System.out.println("Char: " + charValue);
            System.out.println("Double: " + doubleValue);
        } catch (IOException e) {
            LOG.error("Failed to read from file '{}'", filePath, e);
        }
    }
}
