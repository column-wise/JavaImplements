package NetworkSimulation.Network;

import NetworkSimulation.DataUnit.DataLinkLayer.EthernetFrame;
import NetworkSimulation.DataUnit.DataUnit;
import NetworkSimulation.Node.Node;
import NetworkSimulation.DataUnit.TransportLayer.UDPDatagram;
import NetworkSimulation.Util.IPUtil;

import java.util.HashSet;
import java.util.Set;

public class Network {
    private int subnetAddress;
    private int subnetMask;
    Set<Node> nodes = new HashSet<Node>();

    public Network(String subnetAddress, String subnetMask) {
        try {
            this.subnetAddress = IPUtil.ipToInt(subnetAddress);
            this.subnetMask = IPUtil.ipToInt(subnetMask);
        } catch (Exception e) {
            this.subnetAddress = 0;
            this.subnetMask = 0;
        }
    }

    public int getSubnetAddress() {
        return subnetAddress;
    }

    public int getSubnetMask() {
        return subnetMask;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void broadcast(DataUnit data) {
        if(!(data instanceof EthernetFrame) || ((EthernetFrame) data).getIPPacket().getProtocol() != 17) {
            return;
        }

        for (Node node : nodes) {
            node.receive(data);
        }
    }
}
