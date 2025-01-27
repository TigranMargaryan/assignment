package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileProcessor {

    private final IPv4Processor ipv4Processor;

    public FileProcessor(final IPv4Processor ipv4Processor) {
        this.ipv4Processor = ipv4Processor;
    }

    public void processFile(final String filePath) throws IOException {
        try (final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IOException("The file " + filePath + " could not be found in the resources directory.");
            }

            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), 16 * 1024)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ipv4Processor.processLine(line.trim());
                }
            }
        }
    }
}
