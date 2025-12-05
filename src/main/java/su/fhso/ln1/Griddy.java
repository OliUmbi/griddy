package su.fhso.ln1;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.view.View;

public class Griddy {

    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode();
        graph.addNode();
        graph.addNode();

        View view = new View(graph);
        view.start();
    }
}
