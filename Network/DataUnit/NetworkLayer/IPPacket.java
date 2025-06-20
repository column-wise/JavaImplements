package Network.DataUnit.NetworkLayer;

import Network.DataUnit.DataUnit;
import Network.DataUnit.TransportLayer.TransportDataUnit;

public class IPPacket implements DataUnit {
    private final String sourceIP;
    private final String destinationIP;
    private final int protocol; // 17=UDP, 6=TCP
    private final TransportDataUnit transportDataUnit; // UDPDatagram 또는 TCPSegment 저장 가능

    public IPPacket(String sourceIP, String destinationIP, int protocol, TransportDataUnit transportSegment) {
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.protocol = protocol;
        this.transportDataUnit = transportSegment;
    }

    @Override
    public String toString() {
        return "IPPacket {\n" +
                "\tSource IP: " + sourceIP + "\n" +
                "\tDestination IP: " + destinationIP + "\n" +
                "\tProtocol: " + protocol + "\n" +
                "\tTransportSegment: " + transportDataUnit.toString().replace("\n", "\n\t") +
                "\n}";
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public int getProtocol() {
        return protocol;
    }

    public TransportDataUnit getTransportDataUnit() {
        return transportDataUnit;
    }
}
