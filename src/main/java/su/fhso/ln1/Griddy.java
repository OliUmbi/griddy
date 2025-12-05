package su.fhso.ln1;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.model.connections.CornerConnection;
import su.fhso.ln1.model.connections.CrossConnection;
import su.fhso.ln1.model.connections.StraightConnection;
import su.fhso.ln1.model.connections.TConnection;
import su.fhso.ln1.model.nodes.ConsumerNode;
import su.fhso.ln1.model.nodes.PipeNode;
import su.fhso.ln1.model.nodes.ProducerNode;
import su.fhso.ln1.model.nodes.SwitchNode;
import su.fhso.ln1.view.View;

public class Griddy {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode(1, 2, new SwitchNode(new CornerConnection()));
        graph.addNode(1, 3, new SwitchNode(new StraightConnection()));
        graph.addNode(2, 3, new SwitchNode(new CrossConnection()));
        graph.addNode(3, 3, new ProducerNode());
        graph.addNode(4, 3, new SwitchNode(new StraightConnection()));
        graph.addNode(5, 3, new SwitchNode(new CornerConnection()));
        graph.addNode(5, 4, new ConsumerNode());

        View view = new View(graph);
        view.start();
    }
}
