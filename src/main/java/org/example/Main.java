package org.example;

import java.io.IOException;
public class Main {

    public static void main(String[] args) {
       final LargeBitSet largeBitSet = new LargeBitSet();
       final IPv4Processor ipv4Processor = new IPv4Processor(largeBitSet);
       final FileProcessor fileProcessor = new FileProcessor(ipv4Processor);

        final String filePath = "ipV4Data.txt";

        try {
            fileProcessor.processFile(filePath);
            int numberOfSetBits = largeBitSet.cardinality();
            System.out.println("Number of unique IPv4 addresses: " + numberOfSetBits);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}