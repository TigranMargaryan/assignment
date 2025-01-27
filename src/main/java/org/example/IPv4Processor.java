package org.example;
public class IPv4Processor {

    private final LargeBitSet largeBitSet;

    public IPv4Processor(final LargeBitSet largeBitSet) {
        this.largeBitSet = largeBitSet;
    }

    public void processLine(final String line) {
        if (line.isEmpty()) {
            return;
        }

        try {
            final int int32Value = ipv4ToInt32(line);
            final long unsignedIndex = Integer.toUnsignedLong(int32Value);
            largeBitSet.set(unsignedIndex);
        } catch (IllegalArgumentException e) {
            System.err.println("Skipping invalid IPv4 address: " + line);
        }
    }

    public static int ipv4ToInt32(final String ip) {
        final String[] octets = ip.split("\\.");
        if (octets.length != 4) {
            throw new IllegalArgumentException("Invalid IPv4 address: " + ip);
        }
        return (Integer.parseInt(octets[0]) << 24) |
                (Integer.parseInt(octets[1]) << 16) |
                (Integer.parseInt(octets[2]) << 8) |
                Integer.parseInt(octets[3]);
    }
}
