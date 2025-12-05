package su.fhso.ln1.model;

import su.fhso.ln1.Griddy;
import su.fhso.ln1.model.connections.Orientation;
import su.fhso.ln1.model.nodes.INode;
import su.fhso.ln1.model.nodes.Node;
import su.fhso.ln1.model.nodes.ProducerNode;

import java.util.ArrayList;

public class Graph {

    private final Node[][] nodes = new Node[Griddy.WIDTH][Griddy.HEIGHT];

    public INode[][] getNodes() {
        return nodes;
    }

    public void addNode(int x, int y, Node node) {
        if (x < 0 || y < 0 || x >= Griddy.WIDTH || y >= Griddy.HEIGHT) {
            throw new IllegalArgumentException("Node is outside of grid");
        }

        node.setOnUpdate(this::updateGraph);
        nodes[x][y] = node;

        updateGraph();
    }

    private void updateGraph() {
        ArrayList<Integer> producers = new ArrayList<>();

        for (int x = 0; x < nodes.length; x++) {
            for (int y = 0; y < nodes[x].length; y++) {
                Node node = nodes[x][y];
                if (node != null) {
                    node.setPowered(false);
                    if (node instanceof ProducerNode producerNode) {
                        producers.add(x);
                        producers.add(y);
                    }
                }
            }
        }

        for (int i = 0; i < producers.size()/2; i++) {
            propagatePower(producers.get(i), producers.get(i+1));
        }
    }

    private void propagatePower(int x, int y) {
        Node node = nodes[x][y];
        if (node.isPowered()) {
            return;
        }

        node.setPowered(true);
        Node neighbor = nodes[x-1][y];
        if (x > 0 && neighbor != null && !neighbor.isPowered() &&
                node.getConnection().connects(Orientation.WEST) &&
                neighbor.getConnection().connects(Orientation.EAST)) {
            propagatePower(x-1, y);
        }
        neighbor = nodes[x][y-1];
        if (y > 0 && neighbor != null && !neighbor.isPowered() &&
                node.getConnection().connects(Orientation.NORTH) &&
                neighbor.getConnection().connects(Orientation.SOUTH)) {
            propagatePower(x, y-1);
        }
        neighbor = nodes[x+1][y];
        if (x < nodes.length - 1 && neighbor != null && !neighbor.isPowered() &&
                node.getConnection().connects(Orientation.EAST) &&
                neighbor.getConnection().connects(Orientation.WEST)) {
            propagatePower(x+1, y);
        }
        neighbor = nodes[x][y+1];
        if (y < nodes[x].length && nodes[x][y+1] != null && !nodes[x][y+1].isPowered() &&
                node.getConnection().connects(Orientation.SOUTH) &&
                neighbor.getConnection().connects(Orientation.NORTH)) {
            propagatePower(x, y+1);
        }
    }
}
